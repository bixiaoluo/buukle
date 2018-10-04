/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.api.inner.cms;

import top.buukle.daoEntity.mc.entity.ArticleContent;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import java.util.List;

/**
 * 
 * @author elvin
 *
 */
public interface ArticleContentService {
	
	/** 
	 * @Description:	分页获取ArticleContent
	 * @param articleContent
	 * @param pageBounds
	 * @return
	 * @return	List<ArticleContent>
	 * @Date	2015年6月12日 上午10:29:17 
	 */
	public List<ArticleContent> getArticleContentByParas(ArticleContent articleContent, PageBounds pageBounds) throws Exception;
	
	/** 
	 * @Description:	根据id获取ArticleContent
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
	public List<ArticleContent> getArticleContentByParas(ArticleContent articleContent) throws Exception;
	/** 
	 * @Description:	添加ArticleContent
	 * @param articleContent
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	public void save(ArticleContent articleContent) throws Exception;
	/** 
	 * @Description:	更新ArticleContent
	 * @param articleContent
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	public void update(ArticleContent articleContent) throws Exception;
	/** 
	 * @Description:	删除ArticleContent
	 * @param articleContent
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	public void delete(ArticleContent articleContent) throws Exception;
	/** 
	 * @Description:	获取ArticleContent信息 不带分页
	 * @param articleContent
	 * @return
	 * @throws Exception
	 * @return	List<ArticleContent>
	 * @Date	2015年6月12日 上午10:30:13 
	 */
	public List<ArticleContent> getArticleContentsByParasNoPage(ArticleContent articleContent) throws Exception;
	

}
