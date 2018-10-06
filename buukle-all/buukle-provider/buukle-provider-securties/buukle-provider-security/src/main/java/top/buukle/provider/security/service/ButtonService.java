/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.security.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import top.buukle.provider.security.entity.Button;

import java.util.List;

/**
 * 
 * @author elvin
 *
 */
public interface ButtonService {
	
	/** 
	 * @Description:	分页获取Button
	 * @param button
	 * @param pageBounds
	 * @return
	 * @return	List<Button>
	 * @Date	2015年6月12日 上午10:29:17 
	 */
	public List<Button> getButtonByParas(Button button, PageBounds pageBounds) throws Exception;
	
	/** 
	 * @Description:	根据id获取Button
	 * @param button
	 * @return
	 * @throws Exception
	 * @return	Button
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public Button getButtonById(Integer id) throws Exception;
	
	/** 
	 * @Description:	根据条件获取Button
	 * @param button
	 * @return
	 * @throws Exception
	 * @return	Button
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public List<Button> getButtonByParas(Button button) throws Exception;
	/** 
	 * @Description:	添加Button
	 * @param button
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	public void save(Button button) throws Exception;
	/** 
	 * @Description:	更新Button
	 * @param button
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	public void update(Button button) throws Exception;
	/** 
	 * @Description:	删除Button
	 * @param button
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	public void delete(Button button) throws Exception;
	/** 
	 * @Description:	获取Button信息 不带分页
	 * @param button
	 * @return
	 * @throws Exception
	 * @return	List<Button>
	 * @Date	2015年6月12日 上午10:30:13 
	 */
	public List<Button> getButtonsByParasNoPage(Button button) throws Exception;
	

}
