/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.api.inner.mc;

import top.buukle.daoEntity.mc.entity.Role;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import java.util.List;

/**
 * 
 * @author elvin
 *
 */
public interface RoleService {
	
	/** 
	 * @Description:	分页获取Role
	 * @param role
	 * @param pageBounds
	 * @return
	 * @return	List<Role>
	 * @Date	2015年6月12日 上午10:29:17 
	 */
	public List<Role> getRoleByParas(Role role, PageBounds pageBounds) throws Exception;
	
	/** 
	 * @Description:	根据id获取Role
	 * @param
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
	public List<Role> getRoleByParas(Role role) throws Exception;
	/** 
	 * @Description:	添加Role
	 * @param role
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	public void save(Role role) throws Exception;
	/** 
	 * @Description:	更新Role
	 * @param role
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	public void update(Role role) throws Exception;
	/** 
	 * @Description:	删除Role
	 * @param role
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	public void delete(Role role) throws Exception;
	/** 
	 * @Description:	获取Role信息 不带分页
	 * @param role
	 * @return
	 * @throws Exception
	 * @return	List<Role>
	 * @Date	2015年6月12日 上午10:30:13 
	 */
	public List<Role> getRolesByParasNoPage(Role role) throws Exception;
	

}
