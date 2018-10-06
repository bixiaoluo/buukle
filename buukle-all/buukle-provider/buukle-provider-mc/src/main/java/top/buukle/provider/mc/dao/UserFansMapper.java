/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.mc.dao;

import top.buukle.provider.mc.entity.UserFans;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
/**
 * 
 * @author elvin
 *
 */

public interface UserFansMapper {
	/** 
	 * @Description:	分页获取UserFans
	 * @param userFans
	 * @param pageBounds
	 * @return
	 * @return	PageList<UserFans>
	 * @Date	2015年6月12日 上午10:29:17 
	 */
	public PageList<UserFans> getUserFansByParas(UserFans userFans,PageBounds pageBounds) throws Exception;
	
	/** 
	 * @Description:	根据id获取UserFans
	 * @param userFans
	 * @return
	 * @throws Exception
	 * @return	UserFans
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public UserFans getUserFansById(Integer id) throws Exception;
	
	/** 
	 * @Description:	根据条件获取UserFans
	 * @param userFans
	 * @return
	 * @throws Exception
	 * @return	UserFans
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public PageList<UserFans> getUserFansByParas(UserFans userFans) throws Exception;
	/** 
	 * @Description:	添加UserFans
	 * @param userFans
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	public Integer save(UserFans userFans) throws Exception;
	/** 
	 * @Description:	更新UserFans
	 * @param userFans
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	public Integer update(UserFans userFans) throws Exception;
	/** 
	 * @Description:	删除UserFans
	 * @param userFans
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	public Integer delete(UserFans userFans) throws Exception;
	/** 
	 * @Description:	获取UserFans信息 不带分页
	 * @param userFans
	 * @return
	 * @throws Exception
	 * @return	PageList<UserFans>
	 * @Date	2015年6月12日 上午10:30:13 
	 */
	public PageList<UserFans> getUserFanssByParasNoPage(UserFans userFans) throws Exception;
}
