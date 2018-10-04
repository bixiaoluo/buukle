/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.mc.service.impl;

import top.buukle.api.inner.mc.UserService;
import top.buukle.daoEntity.mc.dao.UserMapper;
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
@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;
	@Override
	public List<User> getUserByParas(User user, PageBounds pageBounds) throws Exception {
		return userMapper.getUserByParas(user, pageBounds);
	}
    @Override
	public User getUserById(Integer id) throws Exception{
//        throw new BaseException(BaseResponseCode.BASE_REQUEST_NULL);
		return userMapper.getUserById(id);
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
}
