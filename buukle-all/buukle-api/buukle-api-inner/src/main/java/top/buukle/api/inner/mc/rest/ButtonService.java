/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.api.inner.mc.rest;

import top.buukle.common.request.BaseRequest;
import top.buukle.common.response.BaseResponse;
import top.buukle.daoEntity.mc.entity.Button;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * 
 * @author elvin
 *
 */
@Path("/api/inner/mc/button")
@Produces({MediaType.APPLICATION_JSON })
@Consumes({MediaType.APPLICATION_JSON })
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
	 * @param
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

	/**
	 * 获取全局按钮列表
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@POST
	@Path("/getGlobalButtonList")
	BaseResponse getGlobalButtonList(BaseRequest request) throws Exception;

	/**
	 * 获取用户按钮列表
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@POST
	@Path("/getUserButtonList")
	BaseResponse getUserButtonList(BaseRequest request) throws Exception;
}
