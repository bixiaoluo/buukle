/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.consumer.cms.service.impl;

import top.buukle.consumer.cms.invoker.UserInvoker;
import top.buukle.daoEntity.mc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 
 * @author elvin
 *
 */
@Service
public class UserServiceImpl implements top.buukle.api.inner.cms.UserService {

    @Autowired
    private top.buukle.api.inner.mc.UserService userService;

    @Autowired
    private UserInvoker userInvoker;

    /**
     * 根据id获取User (dubbo 协议调用测试)
     * @param id
     * @return
     * @throws Exception
     */
    @Override
	public User getUserById(Integer id) throws Exception{
		return userService.getUserById(id);
	}
}
