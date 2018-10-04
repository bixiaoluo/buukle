/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.api.inner.mc;

import top.buukle.daoEntity.mc.entity.UserMessage;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import java.util.List;

/**
 * 
 * @author elvin
 *
 */
public interface UserMessageService {
	
	/** 
	 * @Description:	分页获取UserMessage
	 * @param userMessage
	 * @param pageBounds
	 * @return
	 * @return	List<UserMessage>
	 * @Date	2015年6月12日 上午10:29:17 
	 */
	public List<UserMessage> getUserMessageByParas(UserMessage userMessage, PageBounds pageBounds) throws Exception;
	
	/** 
	 * @Description:	根据id获取UserMessage
	 * @param
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
	public List<UserMessage> getUserMessageByParas(UserMessage userMessage) throws Exception;
	/** 
	 * @Description:	添加UserMessage
	 * @param userMessage
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	public void save(UserMessage userMessage) throws Exception;
	/** 
	 * @Description:	更新UserMessage
	 * @param userMessage
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	public void update(UserMessage userMessage) throws Exception;
	/** 
	 * @Description:	删除UserMessage
	 * @param userMessage
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	public void delete(UserMessage userMessage) throws Exception;
	/** 
	 * @Description:	获取UserMessage信息 不带分页
	 * @param userMessage
	 * @return
	 * @throws Exception
	 * @return	List<UserMessage>
	 * @Date	2015年6月12日 上午10:30:13 
	 */
	public List<UserMessage> getUserMessagesByParasNoPage(UserMessage userMessage) throws Exception;
	

}
