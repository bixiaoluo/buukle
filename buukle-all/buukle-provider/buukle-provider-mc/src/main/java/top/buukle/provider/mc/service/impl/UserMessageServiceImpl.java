/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.mc.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import top.buukle.provider.mc.dao.UserMessageMapper;
import top.buukle.provider.mc.entity.UserMessage;
import top.buukle.provider.mc.service.UserMessageService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

/**
 * 
 * @author elvin
 *
 */
@Service("userMessageService")
public class UserMessageServiceImpl implements UserMessageService {
	@Resource
	UserMessageMapper userMessageMapper;
	@Override
	public List<UserMessage> getUserMessageByParas(UserMessage userMessage, PageBounds pageBounds) throws Exception {
		return userMessageMapper.getUserMessageByParas(userMessage, pageBounds);
	}
	@Override
	public UserMessage getUserMessageById(Integer id) throws Exception{
		return userMessageMapper.getUserMessageById(id);
	}
	
	@Override
	public List<UserMessage> getUserMessageByParas(UserMessage userMessage) throws Exception {
		return userMessageMapper.getUserMessageByParas(userMessage);
	}
	@Override
	public void save(UserMessage userMessage) throws Exception {
		userMessageMapper.save(userMessage);
	}
	@Override
	public void update(UserMessage userMessage) throws Exception {
		userMessageMapper.update(userMessage);
	}
	@Override
	public void delete(UserMessage userMessage) throws Exception {
	}
	@Override
	public List<UserMessage> getUserMessagesByParasNoPage(UserMessage userMessage) throws Exception {
		return null;
	}
}
