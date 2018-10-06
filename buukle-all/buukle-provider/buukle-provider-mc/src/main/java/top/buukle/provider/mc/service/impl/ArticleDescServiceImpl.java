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
import top.buukle.provider.mc.dao.ArticleDescMapper;
import top.buukle.provider.mc.entity.ArticleDesc;
import top.buukle.provider.mc.service.ArticleDescService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

/**
 * 
 * @author elvin
 *
 */
@Service("articleDescService")
public class ArticleDescServiceImpl implements ArticleDescService {
	@Resource
	ArticleDescMapper articleDescMapper;
	@Override
	public List<ArticleDesc> getArticleDescByParas(ArticleDesc articleDesc, PageBounds pageBounds) throws Exception {
		return articleDescMapper.getArticleDescByParas(articleDesc, pageBounds);
	}
	@Override
	public ArticleDesc getArticleDescById(Integer id) throws Exception{
		return articleDescMapper.getArticleDescById(id);
	}
	
	@Override
	public List<ArticleDesc> getArticleDescByParas(ArticleDesc articleDesc) throws Exception {
		return articleDescMapper.getArticleDescByParas(articleDesc);
	}
	@Override
	public void save(ArticleDesc articleDesc) throws Exception {
		articleDescMapper.save(articleDesc);
	}
	@Override
	public void update(ArticleDesc articleDesc) throws Exception {
		articleDescMapper.update(articleDesc);
	}
	@Override
	public void delete(ArticleDesc articleDesc) throws Exception {
	}
	@Override
	public List<ArticleDesc> getArticleDescsByParasNoPage(ArticleDesc articleDesc) throws Exception {
		return null;
	}
}
