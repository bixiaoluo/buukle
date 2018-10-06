/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.mc.dao;

import top.buukle.provider.mc.entity.FriendLink;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
/**
 * 
 * @author elvin
 *
 */

public interface FriendLinkMapper {
	/** 
	 * @Description:	分页获取FriendLink
	 * @param friendLink
	 * @param pageBounds
	 * @return
	 * @return	PageList<FriendLink>
	 * @Date	2015年6月12日 上午10:29:17 
	 */
	public PageList<FriendLink> getFriendLinkByParas(FriendLink friendLink,PageBounds pageBounds) throws Exception;
	
	/** 
	 * @Description:	根据id获取FriendLink
	 * @param friendLink
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
	public PageList<FriendLink> getFriendLinkByParas(FriendLink friendLink) throws Exception;
	/** 
	 * @Description:	添加FriendLink
	 * @param friendLink
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	public Integer save(FriendLink friendLink) throws Exception;
	/** 
	 * @Description:	更新FriendLink
	 * @param friendLink
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	public Integer update(FriendLink friendLink) throws Exception;
	/** 
	 * @Description:	删除FriendLink
	 * @param friendLink
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	public Integer delete(FriendLink friendLink) throws Exception;
	/** 
	 * @Description:	获取FriendLink信息 不带分页
	 * @param friendLink
	 * @return
	 * @throws Exception
	 * @return	PageList<FriendLink>
	 * @Date	2015年6月12日 上午10:30:13 
	 */
	public PageList<FriendLink> getFriendLinksByParasNoPage(FriendLink friendLink) throws Exception;
}
