/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.security.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.springframework.stereotype.Service;
import top.buukle.provider.security.service.RoleModuleService;
import top.buukle.provider.security.dao.RoleModuleMapper;
import top.buukle.provider.security.entity.RoleModule;

import javax.annotation.Resource;
import java.util.List;

/**
 * 
 * @author elvin
 *
 */
@Service("roleModuleService")
public class RoleModuleServiceImpl implements RoleModuleService {
	@Resource
	RoleModuleMapper roleModuleMapper;
	@Override
	public List<RoleModule> getRoleModuleByParas(RoleModule roleModule, PageBounds pageBounds) throws Exception {
		return roleModuleMapper.getRoleModuleByParas(roleModule, pageBounds);
	}
	@Override
	public RoleModule getRoleModuleById(Integer id) throws Exception{
		return roleModuleMapper.getRoleModuleById(id);
	}
	
	@Override
	public List<RoleModule> getRoleModuleByParas(RoleModule roleModule) throws Exception {
		return roleModuleMapper.getRoleModuleByParas(roleModule);
	}
	@Override
	public void save(RoleModule roleModule) throws Exception {
		roleModuleMapper.save(roleModule);
	}
	@Override
	public void update(RoleModule roleModule) throws Exception {
		roleModuleMapper.update(roleModule);
	}
	@Override
	public void delete(RoleModule roleModule) throws Exception {
	}
	@Override
	public List<RoleModule> getRoleModulesByParasNoPage(RoleModule roleModule) throws Exception {
		return null;
	}
}
