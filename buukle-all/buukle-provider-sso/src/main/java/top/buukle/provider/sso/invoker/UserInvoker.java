package top.buukle.provider.sso.invoker;

import com.alibaba.fastjson.JSON;
import top.buukle.api.out.sso.entity.Button;
import top.buukle.api.out.sso.entity.Module;
import top.buukle.api.out.sso.entity.Role;
import top.buukle.common.request.BaseRequest;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.util.logger.BaseLogger;
import top.buukle.provider.sso.util.HttpUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/21.
 * @Description :
 */
public class UserInvoker {

    final private static BaseLogger LOGGER = BaseLogger.getLogger(UserInvoker.class);

    public static BaseResponse getUserById(Integer id) {
        ArrayList<String> restParamList = new ArrayList<>();
        restParamList.add(id.toString());
        ArrayList<String> objects = new ArrayList<>();
        objects.add(id+"");
        return HttpUtil.invoker(HttpUtil.METHOD_SSO_GET_USER_BY_ID, objects);
    }

    public static BaseResponse getUserById(BaseRequest request) throws Exception {
        LOGGER.info("调用mc:{}接口,获取用户信息,请求:{}",HttpUtil.METHOD_URL_MAP.get(HttpUtil.METHOD_SSO_GET_USER_BY_ID),JSON.toJSONString(request));
        BaseResponse response = HttpUtil.invoker(HttpUtil.METHOD_SSO_GET_USER_BY_ID, JSON.toJSONString(request));
        LOGGER.info("调用mc:{}接口,获取用户信息,返回:{}",HttpUtil.METHOD_URL_MAP.get(HttpUtil.METHOD_SSO_GET_USER_BY_ID),JSON.toJSONString(response));
        return response;
    }

    public static BaseResponse getUserInfoForLogin(BaseRequest request) throws Exception {
        LOGGER.info("调用mc:{}接口,获取用户信息,请求:{}",HttpUtil.METHOD_URL_MAP.get(HttpUtil.METHOD_SSO_GET_USER_INFO_FOR_LOGIN),JSON.toJSONString(request));
        BaseResponse response = HttpUtil.invoker(HttpUtil.METHOD_SSO_GET_USER_INFO_FOR_LOGIN, JSON.toJSONString(request));
        LOGGER.info("调用mc:{}接口,获取用户信息,返回:{}",HttpUtil.METHOD_URL_MAP.get(HttpUtil.METHOD_SSO_GET_USER_INFO_FOR_LOGIN),JSON.toJSONString(response));
        return response;
    }

    public static List<Module> getGlobalModuleList(BaseRequest request) throws Exception {
        LOGGER.info("调用mc: {} 接口,获取全局菜单列表信息,请求:{}",HttpUtil.METHOD_SSO_GET_GLOBAL_MODULE_LIST, JSON.toJSONString(request));
        BaseResponse response = HttpUtil.invoker(HttpUtil.METHOD_SSO_GET_GLOBAL_MODULE_LIST, JSON.toJSONString(request));
        LOGGER.info("调用mc: {} 接口,获取全局菜单列表信息,返回:{}",HttpUtil.METHOD_SSO_GET_GLOBAL_MODULE_LIST,JSON.toJSONString(response));
        return response.getListData(Module.class);
    }

    public static List<Button> getGlobalButtonList(BaseRequest request) throws Exception {
        LOGGER.info("调用mc: {} 接口,获取全局按钮列表信息,请求:{}",HttpUtil.METHOD_SSO_GET_GLOBAL_BUTTON_LIST,JSON.toJSONString(request));
        BaseResponse response = HttpUtil.invoker(HttpUtil.METHOD_SSO_GET_GLOBAL_BUTTON_LIST, JSON.toJSONString(request));
        LOGGER.info("调用mc: {} 接口,获取全局按钮列表信息,返回:{}",HttpUtil.METHOD_SSO_GET_GLOBAL_BUTTON_LIST,JSON.toJSONString(response));
        return response.getListData(Button.class);
    }

    public static List<Role> getUserRoleList(BaseRequest request) throws Exception {
        LOGGER.info("调用mc: {} 接口,获取用户角色列表信息,请求:{}",HttpUtil.METHOD_SSO_GET_USER_ROLE_LIST,JSON.toJSONString(request));
        BaseResponse response = HttpUtil.invoker(HttpUtil.METHOD_SSO_GET_USER_ROLE_LIST, JSON.toJSONString(request));
        LOGGER.info("调用mc: {} 接口,获取用户角色列表信息,返回:{}",HttpUtil.METHOD_SSO_GET_USER_ROLE_LIST,JSON.toJSONString(response));
        return response.getListData(Button.class);
    }

    public static List<Module> getUserModuleList(BaseRequest request) throws Exception {
        LOGGER.info("调用mc: {} 接口,获取用户菜单列表信息,请求:{}",HttpUtil.METHOD_SSO_GET_USER_MODULE_LIST,JSON.toJSONString(request));
        BaseResponse response = HttpUtil.invoker(HttpUtil.METHOD_SSO_GET_USER_MODULE_LIST,JSON.toJSONString(request));
        LOGGER.info("调用mc: {} 接口,获取用户菜单列表信息,返回:{}",HttpUtil.METHOD_SSO_GET_USER_MODULE_LIST,JSON.toJSONString(response));
        return response.getListData(Module.class);
    }

    public static List<Button> getUserButtonList(BaseRequest request) throws Exception {
        LOGGER.info("调用mc: {} 接口,获取用户按钮列表信息,请求:{}",HttpUtil.METHOD_SSO_GET_USER_BUTTON_LIST,JSON.toJSONString(request));
        BaseResponse response = HttpUtil.invoker(HttpUtil.METHOD_SSO_GET_USER_BUTTON_LIST, JSON.toJSONString(request));
        LOGGER.info("调用mc: {} 接口,获取用户按钮列表信息,返回:{}",HttpUtil.METHOD_SSO_GET_USER_BUTTON_LIST,JSON.toJSONString(response));
        return response.getListData(Button.class);
    }

}
