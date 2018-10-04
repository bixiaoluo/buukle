/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.api.inner.cms;

import top.buukle.daoEntity.mc.entity.User;

/**
 * 
 * @author elvin
 *
 */
public interface UserService {
	
	/**
	 * @Description:	根据id获取User (dubbo 协议调用测试)
	 * @param
	 * @return
	 * @throws Exception
	 * @return	User
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public User getUserById(Integer id) throws Exception;

}
