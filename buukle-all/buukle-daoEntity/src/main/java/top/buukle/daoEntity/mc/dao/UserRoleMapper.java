/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.daoEntity.mc.dao;

import top.buukle.daoEntity.mc.entity.UserRole;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

/**
 * 
 * @author elvin
 *
 */

public interface UserRoleMapper {
	/** 
	 * @Description:	分页获取UserRole
	 * @param userRole
	 * @param pageBounds
	 * @return
	 * @return	PageList<UserRole>
	 * @Date	2015年6月12日 上午10:29:17 
	 */
	public PageList<UserRole> getUserRoleByParas(UserRole userRole, PageBounds pageBounds) throws Exception;
	
	/** 
	 * @Description:	根据id获取UserRole
	 * @return
	 * @throws Exception
	 * @return	UserRole
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public UserRole getUserRoleById(Integer id) throws Exception;
	
	/** 
	 * @Description:	根据条件获取UserRole
	 * @param userRole
	 * @return
	 * @throws Exception
	 * @return	UserRole
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public PageList<UserRole> getUserRoleByParas(UserRole userRole) throws Exception;
	/** 
	 * @Description:	添加UserRole
	 * @param userRole
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	public Integer save(UserRole userRole) throws Exception;
	/** 
	 * @Description:	更新UserRole
	 * @param userRole
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	public Integer update(UserRole userRole) throws Exception;
	/** 
	 * @Description:	删除UserRole
	 * @param userRole
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	public Integer delete(UserRole userRole) throws Exception;
	/** 
	 * @Description:	获取UserRole信息 不带分页
	 * @param userRole
	 * @return
	 * @throws Exception
	 * @return	PageList<UserRole>
	 * @Date	2015年6月12日 上午10:30:13 
	 */
	public PageList<UserRole> getUserRolesByParasNoPage(UserRole userRole) throws Exception;
}
