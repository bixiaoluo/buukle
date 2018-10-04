/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.api.inner.mc.rest;

import top.buukle.daoEntity.mc.entity.ArticleComment;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import java.util.List;

/**
 * 
 * @author elvin
 *
 */
public interface ArticleCommentService {
	
	/** 
	 * @Description:	分页获取ArticleComment
	 * @param articleComment
	 * @param pageBounds
	 * @return
	 * @return	List<ArticleComment>
	 * @Date	2015年6月12日 上午10:29:17 
	 */
	public List<ArticleComment> getArticleCommentByParas(ArticleComment articleComment, PageBounds pageBounds) throws Exception;
	
	/** 
	 * @Description:	根据id获取ArticleComment
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
	public List<ArticleComment> getArticleCommentByParas(ArticleComment articleComment) throws Exception;
	/** 
	 * @Description:	添加ArticleComment
	 * @param articleComment
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	public void save(ArticleComment articleComment) throws Exception;
	/** 
	 * @Description:	更新ArticleComment
	 * @param articleComment
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	public void update(ArticleComment articleComment) throws Exception;
	/** 
	 * @Description:	删除ArticleComment
	 * @param articleComment
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	public void delete(ArticleComment articleComment) throws Exception;
	/** 
	 * @Description:	获取ArticleComment信息 不带分页
	 * @param articleComment
	 * @return
	 * @throws Exception
	 * @return	List<ArticleComment>
	 * @Date	2015年6月12日 上午10:30:13 
	 */
	public List<ArticleComment> getArticleCommentsByParasNoPage(ArticleComment articleComment) throws Exception;
	

}
