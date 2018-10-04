/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.daoEntity.mc.dao;

import top.buukle.daoEntity.mc.entity.ArticleDesc;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

/**
 * 
 * @author elvin
 *
 */

public interface ArticleDescMapper {
	/** 
	 * @Description:	分页获取ArticleDesc
	 * @param articleDesc
	 * @param pageBounds
	 * @return
	 * @return	PageList<ArticleDesc>
	 * @Date	2015年6月12日 上午10:29:17 
	 */
	public PageList<ArticleDesc> getArticleDescByParas(ArticleDesc articleDesc, PageBounds pageBounds) throws Exception;
	
	/** 
	 * @Description:	根据id获取ArticleDesc
	 * @return
	 * @throws Exception
	 * @return	ArticleDesc
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public ArticleDesc getArticleDescById(Integer id) throws Exception;
	
	/** 
	 * @Description:	根据条件获取ArticleDesc
	 * @param articleDesc
	 * @return
	 * @throws Exception
	 * @return	ArticleDesc
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public PageList<ArticleDesc> getArticleDescByParas(ArticleDesc articleDesc) throws Exception;
	/** 
	 * @Description:	添加ArticleDesc
	 * @param articleDesc
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	public Integer save(ArticleDesc articleDesc) throws Exception;
	/** 
	 * @Description:	更新ArticleDesc
	 * @param articleDesc
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	public Integer update(ArticleDesc articleDesc) throws Exception;
	/** 
	 * @Description:	删除ArticleDesc
	 * @param articleDesc
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	public Integer delete(ArticleDesc articleDesc) throws Exception;
	/** 
	 * @Description:	获取ArticleDesc信息 不带分页
	 * @param articleDesc
	 * @return
	 * @throws Exception
	 * @return	PageList<ArticleDesc>
	 * @Date	2015年6月12日 上午10:30:13 
	 */
	public PageList<ArticleDesc> getArticleDescsByParasNoPage(ArticleDesc articleDesc) throws Exception;
}
