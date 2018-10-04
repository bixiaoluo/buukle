/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.daoEntity.mc.dao;

import top.buukle.daoEntity.mc.entity.User;
import top.buukle.daoEntity.mc.vo.result.UserLoginPermissionResult;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import java.util.List;

/**
 * 
 * @author elvin
 *
 */

public interface UserMapper {
	/** 
	 * @Description:	分页获取User
	 * @param user
	 * @param pageBounds
	 * @return
	 * @return	PageList<User>
	 * @Date	2015年6月12日 上午10:29:17 
	 */
	public PageList<User> getUserByParas(User user, PageBounds pageBounds) throws Exception;
	
	/** 
	 * @Description:	根据id获取User
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
	public PageList<User> getUserByParas(User user) throws Exception;
	/** 
	 * @Description:	添加User
	 * @param user
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	public Integer save(User user) throws Exception;
	/** 
	 * @Description:	更新User
	 * @param user
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	public Integer update(User user) throws Exception;
	/** 
	 * @Description:	删除User
	 * @param user
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	public Integer delete(User user) throws Exception;
	/** 
	 * @Description:	获取User信息 不带分页
	 * @param user
	 * @return
	 * @throws Exception
	 * @return	PageList<User>
	 * @Date	2015年6月12日 上午10:30:13 
	 */
	public PageList<User> getUsersByParasNoPage(User user) throws Exception;

	/**
	 * 登录时查询用户基本信息
	 * @param user
	 * @return
	 */
    User getUserInfoForLogin(User user);

    /**
     *查询用户所辖下级用户信息
     * @param userLoginPermissionResult
     * @return
     */
    List<User> getUserSubordinateList(UserLoginPermissionResult userLoginPermissionResult);
}
