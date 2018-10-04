/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.daoEntity.mc.dao;

import top.buukle.daoEntity.mc.entity.UserMessage;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

/**
 * 
 * @author elvin
 *
 */

public interface UserMessageMapper {
	/** 
	 * @Description:	分页获取UserMessage
	 * @param userMessage
	 * @param pageBounds
	 * @return
	 * @return	PageList<UserMessage>
	 * @Date	2015年6月12日 上午10:29:17 
	 */
	public PageList<UserMessage> getUserMessageByParas(UserMessage userMessage, PageBounds pageBounds) throws Exception;
	
	/** 
	 * @Description:	根据id获取UserMessage
	 * @return
	 * @throws Exception
	 * @return	UserMessage
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public UserMessage getUserMessageById(Integer id) throws Exception;
	
	/** 
	 * @Description:	根据条件获取UserMessage
	 * @param userMessage
	 * @return
	 * @throws Exception
	 * @return	UserMessage
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public PageList<UserMessage> getUserMessageByParas(UserMessage userMessage) throws Exception;
	/** 
	 * @Description:	添加UserMessage
	 * @param userMessage
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	public Integer save(UserMessage userMessage) throws Exception;
	/** 
	 * @Description:	更新UserMessage
	 * @param userMessage
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	public Integer update(UserMessage userMessage) throws Exception;
	/** 
	 * @Description:	删除UserMessage
	 * @param userMessage
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	public Integer delete(UserMessage userMessage) throws Exception;
	/** 
	 * @Description:	获取UserMessage信息 不带分页
	 * @param userMessage
	 * @return
	 * @throws Exception
	 * @return	PageList<UserMessage>
	 * @Date	2015年6月12日 上午10:30:13 
	 */
	public PageList<UserMessage> getUserMessagesByParasNoPage(UserMessage userMessage) throws Exception;
}
