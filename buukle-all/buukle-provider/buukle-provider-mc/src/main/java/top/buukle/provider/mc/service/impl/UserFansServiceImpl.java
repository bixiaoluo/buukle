/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.mc.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import top.buukle.provider.mc.dao.UserFansMapper;
import top.buukle.provider.mc.entity.UserFans;
import top.buukle.provider.mc.service.UserFansService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

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
