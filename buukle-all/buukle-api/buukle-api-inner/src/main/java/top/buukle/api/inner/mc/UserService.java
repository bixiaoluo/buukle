/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.api.inner.mc;

import top.buukle.daoEntity.mc.entity.User;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import java.util.List;

/**
 * 
 * @author elvin
 *
 */
public interface UserService {
	
	/** 
	 * @Description:	分页获取User
	 * @param user
	 * @param pageBounds
	 * @return
	 * @return	List<User>
	 * @Date	2015年6月12日 上午10:29:17 
	 */
	public List<User> getUserByParas(User user, PageBounds pageBounds) throws Exception;
	
	/** 
	 * @Description:	根据id获取User
	 * @param
	 * @return
	 * @throws Exception
	 * @return	User
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public User getUserById(Integer id) throws Exception;
	
	/** 
	 * @Description:	根据条件获取User
	 * @param user
	 * @return
	 * @throws Exception
	 * @return	User
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public List<User> getUserByParas(User user) throws Exception;
	/** 
	 * @Description:	添加User
	 * @param user
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	public void save(User user) throws Exception;
	/** 
	 * @Description:	更新User
	 * @param user
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	public void update(User user) throws Exception;
	/** 
	 * @Description:	删除User
	 * @param user
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	public void delete(User user) throws Exception;
	/** 
	 * @Description:	获取User信息 不带分页
	 * @param user
	 * @return
	 * @throws Exception
	 * @return	List<User>
	 * @Date	2015年6月12日 上午10:30:13 
	 */
	public List<User> getUsersByParasNoPage(User user) throws Exception;
	

}
