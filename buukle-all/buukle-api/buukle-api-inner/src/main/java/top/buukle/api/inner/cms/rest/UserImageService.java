/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.api.inner.cms.rest;

import top.buukle.daoEntity.mc.entity.UserImage;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import java.util.List;

/**
 * 
 * @author elvin
 *
 */
public interface UserImageService {
	
	/** 
	 * @Description:	分页获取UserImage
	 * @param userImage
	 * @param pageBounds
	 * @return
	 * @return	List<UserImage>
	 * @Date	2015年6月12日 上午10:29:17 
	 */
	public List<UserImage> getUserImageByParas(UserImage userImage, PageBounds pageBounds) throws Exception;
	
	/** 
	 * @Description:	根据id获取UserImage
	 * @param
	 * @return
	 * @throws Exception
	 * @return	UserImage
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public UserImage getUserImageById(Integer id) throws Exception;
	
	/** 
	 * @Description:	根据条件获取UserImage
	 * @param userImage
	 * @return
	 * @throws Exception
	 * @return	UserImage
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public List<UserImage> getUserImageByParas(UserImage userImage) throws Exception;
	/** 
	 * @Description:	添加UserImage
	 * @param userImage
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	public void save(UserImage userImage) throws Exception;
	/** 
	 * @Description:	更新UserImage
	 * @param userImage
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	public void update(UserImage userImage) throws Exception;
	/** 
	 * @Description:	删除UserImage
	 * @param userImage
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	public void delete(UserImage userImage) throws Exception;
	/** 
	 * @Description:	获取UserImage信息 不带分页
	 * @param userImage
	 * @return
	 * @throws Exception
	 * @return	List<UserImage>
	 * @Date	2015年6月12日 上午10:30:13 
	 */
	public List<UserImage> getUserImagesByParasNoPage(UserImage userImage) throws Exception;
	

}
