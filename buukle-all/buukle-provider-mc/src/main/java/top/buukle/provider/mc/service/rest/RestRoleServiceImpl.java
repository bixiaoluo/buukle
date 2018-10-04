/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.mc.service.rest;

import top.buukle.api.inner.mc.rest.RoleService;
import top.buukle.common.constants.BaseResponseCode;
import top.buukle.common.exception.BaseException;
import top.buukle.common.request.BaseRequest;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.util.common.StringUtil;
import top.buukle.daoEntity.mc.dao.RoleMapper;
import top.buukle.daoEntity.mc.entity.Role;
import top.buukle.daoEntity.mc.entity.User;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 
 * @author elvin
 *
 */
@Service("restRoleService")
public class RestRoleServiceImpl implements RoleService {
	@Resource
	RoleMapper roleMapper;
	@Override
	public List<Role> getRoleByParas(Role role, PageBounds pageBounds) throws Exception {
		return roleMapper.getRoleByParas(role, pageBounds);
	}
	@Override
	public Role getRoleById(Integer id) throws Exception{
		return roleMapper.getRoleById(id);
	}
	
	@Override
	public List<Role> getRoleByParas(Role role) throws Exception {
		return roleMapper.getRoleByParas(role);
	}
	@Override
	public void save(Role role) throws Exception {
		roleMapper.save(role);
	}
	@Override
	public void update(Role role) throws Exception {
		roleMapper.update(role);
	}
	@Override
	public void delete(Role role) throws Exception {
	}
	@Override
	public List<Role> getRolesByParasNoPage(Role role) throws Exception {
		return null;
	}

	/**
	 * 获取用户角色信息列表
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public BaseResponse getUserRoleList(BaseRequest request) throws Exception {
        //初始化请求对象
        User user = (User) request.getInfo(User.class);
        //校验参数
        this.validateGetUserRoleListParam(user);
        List<Role> roleList = roleMapper.getuserRoleListByUserId(user.getUserId());
        return new BaseResponse.Builder().buildSuccess(roleList);
	}

    /**
     * 校验并初始化请求对象
     * @param user
     * @return
     */
    private void validateGetUserRoleListParam(User user) {
        if(null == user || StringUtil.isEmpty(user.getUserId())){
            throw new BaseException(BaseResponseCode.BASE_REQUEST_NULL);
        }
    }
}
