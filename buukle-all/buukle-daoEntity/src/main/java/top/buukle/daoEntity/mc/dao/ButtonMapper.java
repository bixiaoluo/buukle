/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.daoEntity.mc.dao;

import top.buukle.daoEntity.mc.entity.Button;
import top.buukle.daoEntity.mc.vo.result.UserLoginPermissionResult;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * @author elvin
 *
 */

public interface ButtonMapper {
	/** 
	 * @Description:	分页获取Button
	 * @param button
	 * @param pageBounds
	 * @return
	 * @return	PageList<Button>
	 * @Date	2015年6月12日 上午10:29:17 
	 */
	public PageList<Button> getButtonByParas(Button button, PageBounds pageBounds) throws Exception;
	
	/** 
	 * @Description:	根据id获取Button
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
	public PageList<Button> getButtonByParas(Button button) throws Exception;
	/** 
	 * @Description:	添加Button
	 * @param button
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	public Integer save(Button button) throws Exception;
	/** 
	 * @Description:	更新Button
	 * @param button
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	public Integer update(Button button) throws Exception;
	/** 
	 * @Description:	删除Button
	 * @param button
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	public Integer delete(Button button) throws Exception;
	/** 
	 * @Description:	获取Button信息 不带分页
	 * @param button
	 * @return
	 * @throws Exception
	 * @return	PageList<Button>
	 * @Date	2015年6月12日 上午10:30:13 
	 */
	public PageList<Button> getButtonsByParasNoPage(Button button) throws Exception;

	/**
	 * 查询用户按钮列表
	 * @param userLoginPermissionResult
	 * @return
	 */
    List<Button> getUserButtonListByModuleList(@Param("userLoginPermissionResult") UserLoginPermissionResult userLoginPermissionResult);

    /**
     * 获取全局按钮列表
     * @return
     */
    List<Button> getGlobalButtonList();
}
