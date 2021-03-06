/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.security.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.springframework.stereotype.Service;
import top.buukle.provider.security.service.UserRoleService;
import top.buukle.provider.security.dao.UserRoleMapper;
import top.buukle.provider.security.entity.UserRole;

import javax.annotation.Resource;
import java.util.List;

/**
 * 
 * @author elvin
 *
 */
@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {
	@Resource
	UserRoleMapper userRoleMapper;
	@Override
	public List<UserRole> getUserRoleByParas(UserRole userRole, PageBounds pageBounds) throws Exception {
		return userRoleMapper.getUserRoleByParas(userRole, pageBounds);
	}
	@Override
	public UserRole getUserRoleById(Integer id) throws Exception{
		return userRoleMapper.getUserRoleById(id);
	}
	
	@Override
	public List<UserRole> getUserRoleByParas(UserRole userRole) throws Exception {
		return userRoleMapper.getUserRoleByParas(userRole);
	}
	@Override
	public void save(UserRole userRole) throws Exception {
		userRoleMapper.save(userRole);
	}
	@Override
	public void update(UserRole userRole) throws Exception {
		userRoleMapper.update(userRole);
	}
	@Override
	public void delete(UserRole userRole) throws Exception {
	}
	@Override
	public List<UserRole> getUserRolesByParasNoPage(UserRole userRole) throws Exception {
		return null;
	}
}
