/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.daoEntity.mc.dao;

import top.buukle.daoEntity.mc.entity.Role;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import java.util.List;

/**
 * 
 * @author elvin
 *
 */

public interface RoleMapper {
	/** 
	 * @Description:	分页获取Role
	 * @param role
	 * @param pageBounds
	 * @return
	 * @return	PageList<Role>
	 * @Date	2015年6月12日 上午10:29:17 
	 */
	public PageList<Role> getRoleByParas(Role role, PageBounds pageBounds) throws Exception;
	
	/** 
	 * @Description:	根据id获取Role
	 * @param role
	 * @return
	 * @throws Exception
	 * @return	Role
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public Role getRoleById(Integer id) throws Exception;
	
	/** 
	 * @Description:	根据条件获取Role
	 * @param role
	 * @return
	 * @throws Exception
	 * @return	Role
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public PageList<Role> getRoleByParas(Role role) throws Exception;
	/** 
	 * @Description:	添加Role
	 * @param role
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	public Integer save(Role role) throws Exception;
	/** 
	 * @Description:	更新Role
	 * @param role
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	public Integer update(Role role) throws Exception;
	/** 
	 * @Description:	删除Role
	 * @param role
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	public Integer delete(Role role) throws Exception;
	/** 
	 * @Description:	获取Role信息 不带分页
	 * @param role
	 * @return
	 * @throws Exception
	 * @return	PageList<Role>
	 * @Date	2015年6月12日 上午10:30:13 
	 */
	public PageList<Role> getRolesByParasNoPage(Role role) throws Exception;

	/**
	 * 根据用户编码获取用户角色信息
	 * @param userId
	 * @return
	 */
    List<Role> getuserRoleListByUserId(String userId);
}
