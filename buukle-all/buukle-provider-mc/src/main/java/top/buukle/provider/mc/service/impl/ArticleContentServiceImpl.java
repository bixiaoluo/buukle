/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.mc.service.impl;

import top.buukle.api.inner.mc.ArticleContentService;
import top.buukle.daoEntity.mc.dao.ArticleContentMapper;
import top.buukle.daoEntity.mc.entity.ArticleContent;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 
 * @author elvin
 *
 */
@Service("articleContentService")
public class ArticleContentServiceImpl implements ArticleContentService {
	@Resource
    ArticleContentMapper articleContentMapper;
	@Override
	public List<ArticleContent> getArticleContentByParas(ArticleContent articleContent, PageBounds pageBounds) throws Exception {
		return articleContentMapper.getArticleContentByParas(articleContent, pageBounds);
	}
	@Override
	public ArticleContent getArticleContentById(Integer id) throws Exception{
		return articleContentMapper.getArticleContentById(id);
	}
	
	@Override
	public List<ArticleContent> getArticleContentByParas(ArticleContent articleContent) throws Exception {
		return articleContentMapper.getArticleContentByParas(articleContent);
	}
	@Override
	public void save(ArticleContent articleContent) throws Exception {
		articleContentMapper.save(articleContent);
	}
	@Override
	public void update(ArticleContent articleContent) throws Exception {
		articleContentMapper.update(articleContent);
	}
	@Override
	public void delete(ArticleContent articleContent) throws Exception {
	}
	@Override
	public List<ArticleContent> getArticleContentsByParasNoPage(ArticleContent articleContent) throws Exception {
		return null;
	}
}
