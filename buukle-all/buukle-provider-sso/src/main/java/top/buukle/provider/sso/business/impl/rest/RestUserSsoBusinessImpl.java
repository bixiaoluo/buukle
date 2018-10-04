package top.buukle.provider.sso.business.impl.rest;

import top.buukle.api.out.sso.entity.Button;
import top.buukle.api.out.sso.entity.Module;
import top.buukle.api.out.sso.entity.Role;
import top.buukle.api.out.sso.entity.User;
import top.buukle.api.out.sso.rest.UserSsoBusiness;
import top.buukle.api.out.sso.vo.result.UserLoginPermissionResult;
import top.buukle.api.out.sso.vo.query.UserLoginPermissionQuery;
import top.buukle.common.constants.BaseResponseCode;
import top.buukle.common.exception.BaseException;
import top.buukle.common.request.BaseRequest;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.util.common.StringUtil;
import top.buukle.common.util.common.ThreadLocalUtil;
import top.buukle.common.util.jedis.RedisString;
import top.buukle.common.util.logger.BaseLogger;
import top.buukle.common.vo.ThreadParam;
import top.buukle.provider.sso.constants.SsoConstants;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;
import top.buukle.provider.sso.invoker.cache.UserInvoker;

import java.util.List;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/21.
 * @Description :
 */
@Component
public class RestUserSsoBusinessImpl implements UserSsoBusiness {

    final private static BaseLogger LOGGER = BaseLogger.getLogger(RestUserSsoBusinessImpl.class);

    private static final String AUTHENTICATION_WRONG = "认证失败";

    /**
     * 测试-添加redis String set API
     * @param key
     * @param value
     */
    @Override
    public void addStr(String key, String value) {
        RedisString.set(key,value);
    }

    /**
     * 测试-查询redis String get API
     * @param key
     * @return
     */
    @Override
    public String getStr(String key) {
        return RedisString.get(key);
    }

    /**
     * 用户登录
     * @param baseRequest
     * @return
     */
    @Override
    public BaseResponse login(BaseRequest baseRequest) throws Exception {
        //校验参数
        this.validateLoginParam(baseRequest);
        //执行登录
        BaseResponse baseResponse = top.buukle.provider.sso.invoker.UserInvoker.getUserInfoForLogin(baseRequest);
        //登录失败
        if(!baseResponse.isSuccess()){
            return baseResponse;
        }
        //登录成功，缓存用户信息
        UserLoginPermissionResult userInfo = (UserLoginPermissionResult) baseResponse.getDataWithIndex(UserLoginPermissionResult.class, 0);
        //缓存用户基本信息
        String userCookie = UserInvoker.saveUser(userInfo.getUser(),baseRequest.getExpandParameterString(),baseRequest.getRequestHead());
        //缓存用户扩展信息
        UserInvoker.saveUserExp(userInfo.getUserExp(),userCookie,baseRequest.getRequestHead());
        //缓存用户所辖信息
        UserInvoker.saveUserSubordinate(userInfo.getUserList(),userCookie,baseRequest.getRequestHead());
        //缓存用户组别信息
        UserInvoker.saveUserGroup(userInfo.getGroupList(),userCookie,baseRequest.getRequestHead());
        //缓存用户角色信息
        UserInvoker.saveUserRole(userInfo.getRoleList(),userCookie,baseRequest.getRequestHead());
        //缓存用户菜单信息
        UserInvoker.saveUserModule(userInfo.getModuleList(),userCookie,baseRequest.getRequestHead());
        //缓存用户按钮信息
        UserInvoker.saveUserButton(userInfo.getButtonList(),userCookie,baseRequest.getRequestHead());

        LOGGER.info(SsoConstants.LOGIN_SUCCESS,((User)baseRequest.getInfo(User.class)).getUsername());
        //组织返回并回写cookie
        return new BaseResponse.Builder().buildSuccess(userCookie);
    }

    /**
     * 用户认证
     * @param request
     * @return
     */
    @Override
    public BaseResponse authentication(BaseRequest request) {
        //初始化认证参数
        String userCookie = (String) request.getInfo(String.class);
        String ssoDefault = request.getExpandParameterString();
        User user = UserInvoker.getUser(userCookie);
        if(null != user){
            //刷新用户缓存失效时间
            UserInvoker.saveUser(user,ssoDefault,request.getRequestHead());
            return new BaseResponse.Builder().buildSuccess(user);
        }
        return new BaseResponse.Builder().buildFailed(AUTHENTICATION_WRONG);
    }

    /**
     * 用户授权
     * @param request
     * @return
     */
    @Override
    public BaseResponse setPermission(BaseRequest request) throws Exception {
        UserLoginPermissionQuery userLoginPermissionQuery = (UserLoginPermissionQuery)request.getInfo(UserLoginPermissionQuery.class);
        //参数检验
        this.validatePermissionParam(userLoginPermissionQuery);
        //初始化认证参数
        String url = userLoginPermissionQuery.getUrl();
        String userCookie = userLoginPermissionQuery.getuserCookie();
        User user = userLoginPermissionQuery.getUser();
        //获取全局菜单缓存
        List<Module> globalModuleList = this.getGlobalModule(request);
        if(CollectionUtils.isEmpty(globalModuleList)){
            throw new BaseException(BaseResponseCode.USER_PERMISSION_GLOBAL_MODULE_LIST_NULL);
        }
        //获取全局按钮缓存
        List<Button> globalButtonList = this.getGlobalButton(request);
        if(CollectionUtils.isEmpty(globalButtonList)){
            throw new BaseException(BaseResponseCode.USER_PERMISSION_GLOBAL_BUTTON_LIST_NULL);
        }
        //判断请求url是否在全局菜单+按钮 列表里
        Boolean isUnderPermission = this.isUnderPermission(url,globalModuleList,globalButtonList);
        if(!isUnderPermission){
            return new BaseResponse.Builder().buildSuccess();
        }
        //获取用户角色列表缓存
        List<Role> userRoleList = this.getUserRole(userCookie,user,request);
        if(CollectionUtils.isEmpty(userRoleList)){
            throw new BaseException(BaseResponseCode.USER_PERMISSION_USER_ROLE_LIST_NULL);
        }
        //获取用户菜单列表缓存
        List<Module> userModuleList = this.getUserModule(userCookie,userRoleList,request);
        if(CollectionUtils.isEmpty(userModuleList)){
            throw new BaseException(BaseResponseCode.USER_PERMISSION_USER_MODULE_LIST_NULL);
        }
        //获取用户按钮列表缓存
        List<Button> userButtonList = this.getUserButton(userCookie,userModuleList,request);
        //判断当前用户是否拥有当前请求url菜单(菜单 + 按钮)
        if(!this.hasPermission(url,userModuleList,userButtonList)){
            throw new BaseException(BaseResponseCode.USER_PERMISSION_USER_NO_PERMISSION);
        }
        return new BaseResponse.Builder().buildSuccess();
    }

    /**
     * 判断当前用户是否有当前url请求菜单
     * @param url
     * @param userModuleList
     * @param userButtonList
     * @return
     */
    private Boolean hasPermission(String url, List<Module> userModuleList, List<Button> userButtonList) {
        for (Module module:  userModuleList) {
            if(StringUtil.isNotEmpty(module.getUrl()) && module.getUrl().equals(url)){
                return true;
            }
        }
        if(CollectionUtils.isNotEmpty(userButtonList)){
            for (Button button:  userButtonList) {
                if(StringUtil.isNotEmpty(button.getUrl()) && button.getUrl().equals(url)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 获取用户按钮列表缓存
     * @param userCookie
     * @param userModuleList
     *@param request  @return
     */
    private List<Button> getUserButton(String userCookie, List<Module> userModuleList, BaseRequest request) throws Exception {
        List<Button> userButtonList =  UserInvoker.getUserButton(userCookie);
        if(CollectionUtils.isEmpty(userButtonList)){
            request.setInfo(userModuleList);
            userButtonList = top.buukle.provider.sso.invoker.UserInvoker.getUserButtonList(request);
            if(CollectionUtils.isNotEmpty(userButtonList)){
                //缓存用户按钮列表缓存
                UserInvoker.saveUserButton(userButtonList,userCookie, request.getRequestHead());
            }
        }
        return userButtonList;
    }
    /**
     * 获取用户菜单列表缓存
     * @param userCookie
     * @param userRoleList
     *@param request  @return
     */
    private List<Module> getUserModule(String userCookie, List<Role> userRoleList, BaseRequest request) throws Exception {
        List<Module> userModuleList =  UserInvoker.getUserModule(userCookie);
        request.setInfo(userRoleList);
        if(CollectionUtils.isEmpty(userModuleList)){
            userModuleList = top.buukle.provider.sso.invoker.UserInvoker.getUserModuleList(request);
            if(CollectionUtils.isNotEmpty(userModuleList)){
                //缓存用户菜单列表缓存
                UserInvoker.saveUserModule(userModuleList,userCookie, request.getRequestHead());
            }
        }
        return userModuleList;
    }

    /**
     * 获取用户角色列表缓存
     * @param userCookie
     * @param user
     * @param request
     * @return
     */
    private List<Role> getUserRole(String userCookie, User user, BaseRequest request) throws Exception {
        List<Role> userRoleList =  UserInvoker.getUserRole(userCookie);
        if(CollectionUtils.isEmpty(userRoleList)){
            request.setInfo(user);
            userRoleList = top.buukle.provider.sso.invoker.UserInvoker.getUserRoleList(request);
            if(CollectionUtils.isNotEmpty(userRoleList)){
                //绑定用户登录策略到线程本地
                ThreadLocalUtil.set(new ThreadParam.Biulder().setLoginStrategy(user.getLoginStrategy()).build());
                //缓存用户角色列表缓存
                UserInvoker.saveUserRole(userRoleList,userCookie, request.getRequestHead());
            }
        }
        return userRoleList;
    }

    /**
     * 获取全局按钮缓存
     * @return
     * @param request
     */
    private List<Button> getGlobalButton(BaseRequest request) throws Exception {
        List<Button> globalButtonList =  UserInvoker.getGlobalButton();
        if(CollectionUtils.isEmpty(globalButtonList)){
            globalButtonList = top.buukle.provider.sso.invoker.UserInvoker.getGlobalButtonList(request);
            if(CollectionUtils.isNotEmpty(globalButtonList)){
                //缓存全局按钮列表缓存
                UserInvoker.saveGlobalButton(globalButtonList);
            }
        }
        return globalButtonList;
    }

    /**
     * 获取全局菜单列表缓存
     * @return
     * @param request
     */
    private List<Module> getGlobalModule(BaseRequest request) throws Exception {
        List<Module> globalModuleList =  UserInvoker.getGlobalModule();
        if(CollectionUtils.isEmpty(globalModuleList)){
            globalModuleList = top.buukle.provider.sso.invoker.UserInvoker.getGlobalModuleList(request);
            if(CollectionUtils.isNotEmpty(globalModuleList)){
                //缓存全局菜单列表缓存
                UserInvoker.saveGlobalModule(globalModuleList);
            }
        }
        return globalModuleList;
    }

    /**
     * 判断url是否在全局菜单+按钮 管理列表
     * @param url
     * @param globalModuleList
     * @param globalButtonList
     * @return
     */
    private Boolean isUnderPermission(String url, List<Module> globalModuleList, List<Button> globalButtonList) {
        for (Module module: globalModuleList) {
            if(StringUtil.isNotEmpty(module.getUrl()) && module.getUrl().equals(url)){
                return true;
            }
        }
        for (Button button: globalButtonList) {
            if(StringUtil.isNotEmpty(button.getUrl()) && button.getUrl().equals(url)){
                return true;
            }
        }
        return false;
    }

    /**
     * 校验授权参数
     * @param userLoginPermissionQuery
     * @return
     */
    private void validatePermissionParam(UserLoginPermissionQuery userLoginPermissionQuery) {
        if(null == userLoginPermissionQuery || (StringUtil.isEmpty(userLoginPermissionQuery.getuserCookie()) && null == userLoginPermissionQuery.getUrl()) || StringUtil.isEmpty(userLoginPermissionQuery.getUrl())){
            throw new BaseException(BaseResponseCode.USER_PERMISSION_PARAM_WRONG);
        }
    }

    /**
     * 校验登录参数
     * @param request
     */
    private void validateLoginParam(BaseRequest request) {
        User user = (User)request.getInfo(User.class);
        if(user == null){
            throw new BaseException(BaseResponseCode.LOGIN_FAILED);
        }
        if(StringUtil.isEmpty(user.getUsername()) || StringUtil.isEmpty(user.getPassword())){
            throw new BaseException(BaseResponseCode.LOGIN_FAILED_USERNAME_PWD_NULL);
        }
        if(user.getLoginStrategy() == null && StringUtil.isEmpty(request.getExpandParameterString())){
            throw new BaseException(BaseResponseCode.LOGIN_FAILED_USER_LOGIN_STRATEGY_AND_DEFAULT_MAX_AGE_NULL);
        }
    }
}
