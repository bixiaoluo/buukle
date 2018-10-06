/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.mc.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import top.buukle.provider.mc.dao.ArticleCommentMapper;
import top.buukle.provider.mc.entity.ArticleComment;
import top.buukle.provider.mc.service.ArticleCommentService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

/**
 * 
 * @author elvin
 *
 */
@Service("articleCommentService")
public class ArticleCommentServiceImpl implements ArticleCommentService {
	@Resource
	ArticleCommentMapper articleCommentMapper;
	@Override
	public List<ArticleComment> getArticleCommentByParas(ArticleComment articleComment, PageBounds pageBounds) throws Exception {
		return articleCommentMapper.getArticleCommentByParas(articleComment, pageBounds);
	}
	@Override
	public ArticleComment getArticleCommentById(Integer id) throws Exception{
		return articleCommentMapper.getArticleCommentById(id);
	}
	
	@Override
	public List<ArticleComment> getArticleCommentByParas(ArticleComment articleComment) throws Exception {
		return articleCommentMapper.getArticleCommentByParas(articleComment);
	}
	@Override
	public void save(ArticleComment articleComment) throws Exception {
		articleCommentMapper.save(articleComment);
	}
	@Override
	public void update(ArticleComment articleComment) throws Exception {
		articleCommentMapper.update(articleComment);
	}
	@Override
	public void delete(ArticleComment articleComment) throws Exception {
	}
	@Override
	public List<ArticleComment> getArticleCommentsByParasNoPage(ArticleComment articleComment) throws Exception {
		return null;
	}
}
