/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.api.inner.mc.rest;

import top.buukle.daoEntity.mc.entity.FriendLink;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import java.util.List;

/**
 * 
 * @author elvin
 *
 */
public interface FriendLinkService {
	
	/** 
	 * @Description:	分页获取FriendLink
	 * @param friendLink
	 * @param pageBounds
	 * @return
	 * @return	List<FriendLink>
	 * @Date	2015年6月12日 上午10:29:17 
	 */
	public List<FriendLink> getFriendLinkByParas(FriendLink friendLink, PageBounds pageBounds) throws Exception;
	
	/** 
	 * @Description:	根据id获取FriendLink
	 * @param
	 * @return
	 * @throws Exception
	 * @return	FriendLink
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public FriendLink getFriendLinkById(Integer id) throws Exception;
	
	/** 
	 * @Description:	根据条件获取FriendLink
	 * @param friendLink
	 * @return
	 * @throws Exception
	 * @return	FriendLink
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public List<FriendLink> getFriendLinkByParas(FriendLink friendLink) throws Exception;
	/** 
	 * @Description:	添加FriendLink
	 * @param friendLink
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	public void save(FriendLink friendLink) throws Exception;
	/** 
	 * @Description:	更新FriendLink
	 * @param friendLink
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	public void update(FriendLink friendLink) throws Exception;
	/** 
	 * @Description:	删除FriendLink
	 * @param friendLink
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	public void delete(FriendLink friendLink) throws Exception;
	/** 
	 * @Description:	获取FriendLink信息 不带分页
	 * @param friendLink
	 * @return
	 * @throws Exception
	 * @return	List<FriendLink>
	 * @Date	2015年6月12日 上午10:30:13 
	 */
	public List<FriendLink> getFriendLinksByParasNoPage(FriendLink friendLink) throws Exception;
	

}
