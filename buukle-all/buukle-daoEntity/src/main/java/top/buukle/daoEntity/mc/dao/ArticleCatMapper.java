/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.daoEntity.mc.dao;

import top.buukle.daoEntity.mc.entity.ArticleCat;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

/**
 * 
 * @author elvin
 *
 */

public interface ArticleCatMapper {
	/** 
	 * @Description:	分页获取ArticleCat
	 * @param articleCat
	 * @param pageBounds
	 * @return
	 * @return	PageList<ArticleCat>
	 * @Date	2015年6月12日 上午10:29:17 
	 */
	public PageList<ArticleCat> getArticleCatByParas(ArticleCat articleCat, PageBounds pageBounds) throws Exception;
	
	/** 
	 * @Description:	根据id获取ArticleCat
	 * @return
	 * @throws Exception
	 * @return	ArticleCat
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public ArticleCat getArticleCatById(Integer id) throws Exception;
	
	/** 
	 * @Description:	根据条件获取ArticleCat
	 * @param articleCat
	 * @return
	 * @throws Exception
	 * @return	ArticleCat
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public PageList<ArticleCat> getArticleCatByParas(ArticleCat articleCat) throws Exception;
	/** 
	 * @Description:	添加ArticleCat
	 * @param articleCat
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	public Integer save(ArticleCat articleCat) throws Exception;
	/** 
	 * @Description:	更新ArticleCat
	 * @param articleCat
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	public Integer update(ArticleCat articleCat) throws Exception;
	/** 
	 * @Description:	删除ArticleCat
	 * @param articleCat
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	public Integer delete(ArticleCat articleCat) throws Exception;
	/** 
	 * @Description:	获取ArticleCat信息 不带分页
	 * @param articleCat
	 * @return
	 * @throws Exception
	 * @return	PageList<ArticleCat>
	 * @Date	2015年6月12日 上午10:30:13 
	 */
	public PageList<ArticleCat> getArticleCatsByParasNoPage(ArticleCat articleCat) throws Exception;
}
