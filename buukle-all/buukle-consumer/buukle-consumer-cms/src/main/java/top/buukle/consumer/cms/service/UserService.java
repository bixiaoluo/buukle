/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.consumer.cms.service;

import top.buukle.provider.security.entity.User;


/**
 * 
 * @author elvin
 *
 */
public interface UserService {


    /**
     * 根据id获取User (dubbo 协议调用测试)
     * @param id
     * @return
     * @throws Exception
     */
	public User getUserById(Integer id) throws Exception;
}
