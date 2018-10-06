/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.security.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import top.buukle.provider.security.entity.ModuleButton;

/**
 * 
 * @author elvin
 *
 */

public interface ModuleButtonMapper {
	/** 
	 * @Description:	分页获取ModuleButton
	 * @param moduleButton
	 * @param pageBounds
	 * @return
	 * @return	PageList<ModuleButton>
	 * @Date	2015年6月12日 上午10:29:17 
	 */
	public PageList<ModuleButton> getModuleButtonByParas(ModuleButton moduleButton, PageBounds pageBounds) throws Exception;
	
	/** 
	 * @Description:	根据id获取ModuleButton
	 * @param moduleButton
	 * @return
	 * @throws Exception
	 * @return	ModuleButton
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public ModuleButton getModuleButtonById(Integer id) throws Exception;
	
	/** 
	 * @Description:	根据条件获取ModuleButton
	 * @param moduleButton
	 * @return
	 * @throws Exception
	 * @return	ModuleButton
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public PageList<ModuleButton> getModuleButtonByParas(ModuleButton moduleButton) throws Exception;
	/** 
	 * @Description:	添加ModuleButton
	 * @param moduleButton
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	public Integer save(ModuleButton moduleButton) throws Exception;
	/** 
	 * @Description:	更新ModuleButton
	 * @param moduleButton
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	public Integer update(ModuleButton moduleButton) throws Exception;
	/** 
	 * @Description:	删除ModuleButton
	 * @param moduleButton
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	public Integer delete(ModuleButton moduleButton) throws Exception;
	/** 
	 * @Description:	获取ModuleButton信息 不带分页
	 * @param moduleButton
	 * @return
	 * @throws Exception
	 * @return	PageList<ModuleButton>
	 * @Date	2015年6月12日 上午10:30:13 
	 */
	public PageList<ModuleButton> getModuleButtonsByParasNoPage(ModuleButton moduleButton) throws Exception;
}
