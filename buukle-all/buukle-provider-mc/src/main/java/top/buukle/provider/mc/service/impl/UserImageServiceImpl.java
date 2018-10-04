/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.mc.service.impl;

import top.buukle.api.inner.mc.UserImageService;
import top.buukle.daoEntity.mc.dao.UserImageMapper;
import top.buukle.daoEntity.mc.entity.UserImage;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 
 * @author elvin
 *
 */
@Service("userImageService")
public class UserImageServiceImpl implements UserImageService {
	@Resource
    UserImageMapper userImageMapper;
	@Override
	public List<UserImage> getUserImageByParas(UserImage userImage, PageBounds pageBounds) throws Exception {
		return userImageMapper.getUserImageByParas(userImage, pageBounds);
	}
	@Override
	public UserImage getUserImageById(Integer id) throws Exception{
		return userImageMapper.getUserImageById(id);
	}
	
	@Override
	public List<UserImage> getUserImageByParas(UserImage userImage) throws Exception {
		return userImageMapper.getUserImageByParas(userImage);
	}
	@Override
	public void save(UserImage userImage) throws Exception {
		userImageMapper.save(userImage);
	}
	@Override
	public void update(UserImage userImage) throws Exception {
		userImageMapper.update(userImage);
	}
	@Override
	public void delete(UserImage userImage) throws Exception {
	}
	@Override
	public List<UserImage> getUserImagesByParasNoPage(UserImage userImage) throws Exception {
		return null;
	}
}
