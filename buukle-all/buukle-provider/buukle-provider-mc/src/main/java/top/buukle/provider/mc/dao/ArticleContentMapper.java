/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.mc.dao;

import top.buukle.provider.mc.entity.ArticleContent;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
/**
 * 
 * @author elvin
 *
 */

public interface ArticleContentMapper {
	/** 
	 * @Description:	分页获取ArticleContent
	 * @param articleContent
	 * @param pageBounds
	 * @return
	 * @return	PageList<ArticleContent>
	 * @Date	2015年6月12日 上午10:29:17 
	 */
	public PageList<ArticleContent> getArticleContentByParas(ArticleContent articleContent,PageBounds pageBounds) throws Exception;
	
	/** 
	 * @Description:	根据id获取ArticleContent
	 * @param articleContent
	 * @return
	 * @throws Exception
	 * @return	ArticleContent
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public ArticleContent getArticleContentById(Integer id) throws Exception;
	
	/** 
	 * @Description:	根据条件获取ArticleContent
	 * @param articleContent
	 * @return
	 * @throws Exception
	 * @return	ArticleContent
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public PageList<ArticleContent> getArticleContentByParas(ArticleContent articleContent) throws Exception;
	/** 
	 * @Description:	添加ArticleContent
	 * @param articleContent
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	public Integer save(ArticleContent articleContent) throws Exception;
	/** 
	 * @Description:	更新ArticleContent
	 * @param articleContent
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	public Integer update(ArticleContent articleContent) throws Exception;
	/** 
	 * @Description:	删除ArticleContent
	 * @param articleContent
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	public Integer delete(ArticleContent articleContent) throws Exception;
	/** 
	 * @Description:	获取ArticleContent信息 不带分页
	 * @param articleContent
	 * @return
	 * @throws Exception
	 * @return	PageList<ArticleContent>
	 * @Date	2015年6月12日 上午10:30:13 
	 */
	public PageList<ArticleContent> getArticleContentsByParasNoPage(ArticleContent articleContent) throws Exception;
}
