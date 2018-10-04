/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.mc.service.impl;

import top.buukle.api.inner.mc.UserAlbumService;
import top.buukle.daoEntity.mc.dao.UserAlbumMapper;
import top.buukle.daoEntity.mc.entity.UserAlbum;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 
 * @author elvin
 *
 */
@Service("userAlbumService")
public class UserAlbumServiceImpl implements UserAlbumService {
	@Resource
	UserAlbumMapper userAlbumMapper;
	@Override
	public List<UserAlbum> getUserAlbumByParas(UserAlbum userAlbum, PageBounds pageBounds) throws Exception {
		return userAlbumMapper.getUserAlbumByParas(userAlbum, pageBounds);
	}
	@Override
	public UserAlbum getUserAlbumById(Integer id) throws Exception{
		return userAlbumMapper.getUserAlbumById(id);
	}
	
	@Override
	public List<UserAlbum> getUserAlbumByParas(UserAlbum userAlbum) throws Exception {
		return userAlbumMapper.getUserAlbumByParas(userAlbum);
	}
	@Override
	public void save(UserAlbum userAlbum) throws Exception {
		userAlbumMapper.save(userAlbum);
	}
	@Override
	public void update(UserAlbum userAlbum) throws Exception {
		userAlbumMapper.update(userAlbum);
	}
	@Override
	public void delete(UserAlbum userAlbum) throws Exception {
	}
	@Override
	public List<UserAlbum> getUserAlbumsByParasNoPage(UserAlbum userAlbum) throws Exception {
		return null;
	}
}
