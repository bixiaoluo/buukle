/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.mc.service.impl;

import top.buukle.api.inner.mc.ModuleService;
import top.buukle.daoEntity.mc.dao.ModuleMapper;
import top.buukle.daoEntity.mc.entity.Module;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 
 * @author elvin
 *
 */
@Service("moduleService")
public class ModuleServiceImpl implements ModuleService {
	@Resource
    ModuleMapper moduleMapper;
	@Override
	public List<Module> getModuleByParas(Module module, PageBounds pageBounds) throws Exception {
		return moduleMapper.getModuleByParas(module, pageBounds);
	}
	@Override
	public Module getModuleById(Integer id) throws Exception{
		return moduleMapper.getModuleById(id);
	}
	
	@Override
	public List<Module> getModuleByParas(Module module) throws Exception {
		return moduleMapper.getModuleByParas(module);
	}
	@Override
	public void save(Module module) throws Exception {
		moduleMapper.save(module);
	}
	@Override
	public void update(Module module) throws Exception {
		moduleMapper.update(module);
	}
	@Override
	public void delete(Module module) throws Exception {
	}
	@Override
	public List<Module> getModulesByParasNoPage(Module module) throws Exception {
		return null;
	}
}
