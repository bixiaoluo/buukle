/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.consumer.cms.service.impl;

import top.buukle.consumer.cms.invoker.UserInvoker;
import top.buukle.consumer.cms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.buukle.provider.security.entity.User;


/**
 * 
 * @author elvin
 *
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInvoker userInvoker;

    /**
     * 根据id获取User
     * @param id
     * @return
     * @throws Exception
     */
    @Override
	public User getUserById(Integer id) throws Exception{
		return userInvoker.getUserById();
	}
}
