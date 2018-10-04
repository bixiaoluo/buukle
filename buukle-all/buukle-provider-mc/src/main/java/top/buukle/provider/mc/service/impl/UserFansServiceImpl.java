/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.mc.service.impl;

import top.buukle.api.inner.mc.UserFansService;
import top.buukle.daoEntity.mc.dao.UserFansMapper;
//import top.buukle.daoEntity.entity.UserFans;
import top.buukle.daoEntity.mc.entity.UserFans;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 
 * @author elvin
 *
 */
@Service("userFansService")
public class UserFansServiceImpl implements UserFansService {
	@Resource
	UserFansMapper userFansMapper;
	@Override
	public List<UserFans> getUserFansByParas(UserFans userFans, PageBounds pageBounds) throws Exception {
		return userFansMapper.getUserFansByParas(userFans, pageBounds);
	}
	@Override
	public UserFans getUserFansById(Integer id) throws Exception{
		return userFansMapper.getUserFansById(id);
	}
	
	@Override
	public List<UserFans> getUserFansByParas(UserFans userFans) throws Exception {
		return userFansMapper.getUserFansByParas(userFans);
	}
	@Override
	public void save(UserFans userFans) throws Exception {
		userFansMapper.save(userFans);
	}
	@Override
	public void update(UserFans userFans) throws Exception {
		userFansMapper.update(userFans);
	}
	@Override
	public void delete(UserFans userFans) throws Exception {
	}
	@Override
	public List<UserFans> getUserFanssByParasNoPage(UserFans userFans) throws Exception {
		return null;
	}
}
