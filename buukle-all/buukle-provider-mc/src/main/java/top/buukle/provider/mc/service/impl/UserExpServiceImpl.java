/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.mc.service.impl;

import top.buukle.api.inner.mc.UserExpService;
import top.buukle.daoEntity.mc.dao.UserExpMapper;
import top.buukle.daoEntity.mc.entity.UserExp;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 
 * @author elvin
 *
 */
@Service("userExpService")
public class UserExpServiceImpl implements UserExpService {
	@Resource
	UserExpMapper userExpMapper;
	@Override
	public List<UserExp> getUserExpByParas(UserExp userExp, PageBounds pageBounds) throws Exception {
		return userExpMapper.getUserExpByParas(userExp, pageBounds);
	}
	@Override
	public UserExp getUserExpById(Integer id) throws Exception{
		return userExpMapper.getUserExpById(id);
	}
	
	@Override
	public List<UserExp> getUserExpByParas(UserExp userExp) throws Exception {
		return userExpMapper.getUserExpByParas(userExp);
	}
	@Override
	public void save(UserExp userExp) throws Exception {
		userExpMapper.save(userExp);
	}
	@Override
	public void update(UserExp userExp) throws Exception {
		userExpMapper.update(userExp);
	}
	@Override
	public void delete(UserExp userExp) throws Exception {
	}
	@Override
	public List<UserExp> getUserExpsByParasNoPage(UserExp userExp) throws Exception {
		return null;
	}
}
