/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.mc.service.rest;

import top.buukle.api.inner.mc.rest.UserService;
import top.buukle.common.constants.BaseResponseCode;
import top.buukle.common.exception.BaseException;
import top.buukle.common.request.BaseRequest;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.util.common.StringUtil;
import top.buukle.daoEntity.mc.dao.*;
import top.buukle.daoEntity.mc.entity.*;
import top.buukle.daoEntity.mc.entity.*;
import top.buukle.daoEntity.mc.vo.result.UserLoginPermissionResult;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import top.buukle.daoEntity.mc.dao.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 
 * @author elvin
 *
 */
@Service
public class RestUserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;
	@Resource
	private UserExpMapper userExpMapper;
	@Resource
	private GroupsMapper groupMapper;
	@Resource
	private RoleMapper roleMapper;
	@Resource
	private ModuleMapper moduleMapper;
	@Resource
	private ButtonMapper buttonMapper;

	@Override
	public List<User> getUserByParas(User user, PageBounds pageBounds) throws Exception {
		return userMapper.getUserByParas(user, pageBounds);
	}

    @Override
	public BaseResponse getUserById(Integer id) throws Exception{
        User user = userMapper.getUserById(id);
        return new BaseResponse.Builder().buildSuccess(user);
	}

    @Override
    public BaseResponse getUserById( BaseRequest request) throws Exception {
        User user = userMapper.getUserById(((User) request.getInfo(User.class)).getId());
//        throw new BaseException(BaseResponseCode.BASE_REQUEST_NULL);
//        throw new Exception();
		return new BaseResponse.Builder().buildSuccess(user);
    }

    @Override
	public List<User> getUserByParas(User user) throws Exception {
		return userMapper.getUserByParas(user);
	}
	@Override
	public void save(User user) throws Exception {
		userMapper.save(user);
	}
	@Override
	public void update(User user) throws Exception {
		userMapper.update(user);
	}
	@Override
	public void delete(User user) throws Exception {
	}
	@Override
	public List<User> getUsersByParasNoPage(User user) throws Exception {
		return null;
	}

	/**
	 * 查询用户登录信息
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public BaseResponse getUserInfoForLogin(BaseRequest request) throws Exception {
        //初始化请求参数
        User user = (User) request.getInfo(User.class);
        //验证参数
        this.validateLoginParam(user);
        //查询用户基本信息
        User userDB = userMapper.getUserInfoForLogin(user);
        if(null == userDB){
            throw new BaseException(BaseResponseCode.USER_LOGIN_USERNAME_PASSWORD_WRONG);
        }
        UserLoginPermissionResult userLoginPermissionResult = new UserLoginPermissionResult();
        userLoginPermissionResult.setUser(userDB);
        //查询用户扩展信息
        UserExp userExp = userExpMapper.getUserExpByUserId(userDB.getUserId());
        userLoginPermissionResult.setUserExp(userExp);
        //查询用户组别信息
        List<Groups> groupList = groupMapper.getUserGroupListByUserId(userDB.getUserId());
        userLoginPermissionResult.setGroupList(groupList);
        //查询用户所辖下级用户信息
        List<User> userList = userMapper.getUserSubordinateList(userLoginPermissionResult);
        userLoginPermissionResult.setUserList(userList);
        //查询用户角色信息
        List<Role> roleList = roleMapper.getuserRoleListByUserId(userDB.getUserId());
        userLoginPermissionResult.setRoleList(roleList);
        //查询用户菜单信息
        List<Module> moduleList = null;
        if(CollectionUtils.isNotEmpty(roleList)){
            moduleList = moduleMapper.getUserModuleListByRoleList(userLoginPermissionResult);
            userLoginPermissionResult.setModuleList(moduleList);
        }
        //查询用户按钮信息
        List<Button> buttonList;
        if(CollectionUtils.isNotEmpty(moduleList)){
            buttonList = buttonMapper.getUserButtonListByModuleList(userLoginPermissionResult);
            userLoginPermissionResult.setButtonList(buttonList);
        }
        //组织返回
		return new BaseResponse.Builder().buildSuccess(userLoginPermissionResult);
	}

    /**
     * 校验登录参数
     * @param user
     */
    private void validateLoginParam(User user) {
        if(null == user ){
            throw new BaseException(BaseResponseCode.USER_LOGIN_PARAM_WRONG);
        }
        if(StringUtil.isEmpty(user.getUsername()) || StringUtil.isEmpty(user.getPassword())){
            throw new BaseException(BaseResponseCode.USER_LOGIN_USERNAME_PASSWORD_NULL);
        }
    }
}
