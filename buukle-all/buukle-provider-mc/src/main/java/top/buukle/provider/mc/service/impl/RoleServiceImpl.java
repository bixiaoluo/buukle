/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.mc.service.impl;

import top.buukle.api.inner.mc.RoleService;
import top.buukle.daoEntity.mc.dao.RoleMapper;
import top.buukle.daoEntity.mc.entity.Role;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 
 * @author elvin
 *
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
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
}
