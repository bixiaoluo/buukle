/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.mc.service.impl;

import top.buukle.api.inner.mc.ButtonService;
import top.buukle.daoEntity.mc.dao.ButtonMapper;
import top.buukle.daoEntity.mc.entity.Button;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 
 * @author elvin
 *
 */
@Service("buttonService")
public class ButtonServiceImpl implements ButtonService {
	@Resource
	ButtonMapper buttonMapper;
	@Override
	public List<Button> getButtonByParas(Button button, PageBounds pageBounds) throws Exception {
		return buttonMapper.getButtonByParas(button, pageBounds);
	}
	@Override
	public Button getButtonById(Integer id) throws Exception{
		return buttonMapper.getButtonById(id);
	}
	
	@Override
	public List<Button> getButtonByParas(Button button) throws Exception {
		return buttonMapper.getButtonByParas(button);
	}
	@Override
	public void save(Button button) throws Exception {
		buttonMapper.save(button);
	}
	@Override
	public void update(Button button) throws Exception {
		buttonMapper.update(button);
	}
	@Override
	public void delete(Button button) throws Exception {
	}
	@Override
	public List<Button> getButtonsByParasNoPage(Button button) throws Exception {
		return null;
	}
}
