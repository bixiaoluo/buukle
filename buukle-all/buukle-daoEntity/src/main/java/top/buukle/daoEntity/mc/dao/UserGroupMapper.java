/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.daoEntity.mc.dao;

import top.buukle.daoEntity.mc.entity.UserGroup;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

/**
 * 
 * @author tengbx
 *
 */

public interface UserGroupMapper {
	/** 
	 * @Description:	分页获取UserGroup
	 * @param userGroup
	 * @param pageBounds
	 * @return
	 * @return	PageList<UserGroup>
	 * @Date	2015年6月12日 上午10:29:17 
	 */
	public PageList<UserGroup> getUserGroupByParas(UserGroup userGroup, PageBounds pageBounds) throws Exception;
	
	/** 
	 * @Description:	根据id获取UserGroup
	 * @return
	 * @throws Exception
	 * @return	UserGroup
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public UserGroup getUserGroupById(Integer id) throws Exception;
	
	/** 
	 * @Description:	根据条件获取UserGroup
	 * @param userGroup
	 * @return
	 * @throws Exception
	 * @return	UserGroup
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public PageList<UserGroup> getUserGroupByParas(UserGroup userGroup) throws Exception;
	/** 
	 * @Description:	添加UserGroup
	 * @param userGroup
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	public Integer save(UserGroup userGroup) throws Exception;
	/** 
	 * @Description:	更新UserGroup
	 * @param userGroup
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	public Integer update(UserGroup userGroup) throws Exception;
	/** 
	 * @Description:	删除UserGroup
	 * @param userGroup
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	public Integer delete(UserGroup userGroup) throws Exception;
	/** 
	 * @Description:	获取UserGroup信息 不带分页
	 * @param userGroup
	 * @return
	 * @throws Exception
	 * @return	PageList<UserGroup>
	 * @Date	2015年6月12日 上午10:30:13 
	 */
	public PageList<UserGroup> getUserGroupsByParasNoPage(UserGroup userGroup) throws Exception;
}
