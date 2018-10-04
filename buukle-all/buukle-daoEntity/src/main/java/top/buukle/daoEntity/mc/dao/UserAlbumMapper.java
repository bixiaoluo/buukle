/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.daoEntity.mc.dao;

import top.buukle.daoEntity.mc.entity.UserAlbum;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

/**
 * 
 * @author elvin
 *
 */

public interface UserAlbumMapper {
	/** 
	 * @Description:	分页获取UserAlbum
	 * @param userAlbum
	 * @param pageBounds
	 * @return
	 * @return	PageList<UserAlbum>
	 * @Date	2015年6月12日 上午10:29:17 
	 */
	public PageList<UserAlbum> getUserAlbumByParas(UserAlbum userAlbum, PageBounds pageBounds) throws Exception;
	
	/** 
	 * @Description:	根据id获取UserAlbum
	 * @return
	 * @throws Exception
	 * @return	UserAlbum
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public UserAlbum getUserAlbumById(Integer id) throws Exception;
	
	/** 
	 * @Description:	根据条件获取UserAlbum
	 * @param userAlbum
	 * @return
	 * @throws Exception
	 * @return	UserAlbum
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public PageList<UserAlbum> getUserAlbumByParas(UserAlbum userAlbum) throws Exception;
	/** 
	 * @Description:	添加UserAlbum
	 * @param userAlbum
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	public Integer save(UserAlbum userAlbum) throws Exception;
	/** 
	 * @Description:	更新UserAlbum
	 * @param userAlbum
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	public Integer update(UserAlbum userAlbum) throws Exception;
	/** 
	 * @Description:	删除UserAlbum
	 * @param userAlbum
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	public Integer delete(UserAlbum userAlbum) throws Exception;
	/** 
	 * @Description:	获取UserAlbum信息 不带分页
	 * @param userAlbum
	 * @return
	 * @throws Exception
	 * @return	PageList<UserAlbum>
	 * @Date	2015年6月12日 上午10:30:13 
	 */
	public PageList<UserAlbum> getUserAlbumsByParasNoPage(UserAlbum userAlbum) throws Exception;
}
