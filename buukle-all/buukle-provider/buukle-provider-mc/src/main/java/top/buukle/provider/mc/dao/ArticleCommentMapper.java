/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.mc.dao;

import top.buukle.provider.mc.entity.ArticleComment;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
/**
 * 
 * @author elvin
 *
 */

public interface ArticleCommentMapper {
	/** 
	 * @Description:	分页获取ArticleComment
	 * @param articleComment
	 * @param pageBounds
	 * @return
	 * @return	PageList<ArticleComment>
	 * @Date	2015年6月12日 上午10:29:17 
	 */
	public PageList<ArticleComment> getArticleCommentByParas(ArticleComment articleComment,PageBounds pageBounds) throws Exception;
	
	/** 
	 * @Description:	根据id获取ArticleComment
	 * @param articleComment
	 * @return
	 * @throws Exception
	 * @return	ArticleComment
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public ArticleComment getArticleCommentById(Integer id) throws Exception;
	
	/** 
	 * @Description:	根据条件获取ArticleComment
	 * @param articleComment
	 * @return
	 * @throws Exception
	 * @return	ArticleComment
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public PageList<ArticleComment> getArticleCommentByParas(ArticleComment articleComment) throws Exception;
	/** 
	 * @Description:	添加ArticleComment
	 * @param articleComment
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	public Integer save(ArticleComment articleComment) throws Exception;
	/** 
	 * @Description:	更新ArticleComment
	 * @param articleComment
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	public Integer update(ArticleComment articleComment) throws Exception;
	/** 
	 * @Description:	删除ArticleComment
	 * @param articleComment
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	public Integer delete(ArticleComment articleComment) throws Exception;
	/** 
	 * @Description:	获取ArticleComment信息 不带分页
	 * @param articleComment
	 * @return
	 * @throws Exception
	 * @return	PageList<ArticleComment>
	 * @Date	2015年6月12日 上午10:30:13 
	 */
	public PageList<ArticleComment> getArticleCommentsByParasNoPage(ArticleComment articleComment) throws Exception;
}
