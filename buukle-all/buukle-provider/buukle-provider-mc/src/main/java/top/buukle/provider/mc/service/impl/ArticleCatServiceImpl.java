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
import top.buukle.provider.mc.dao.ArticleCatMapper;
import top.buukle.provider.mc.entity.ArticleCat;
import top.buukle.provider.mc.service.ArticleCatService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

/**
 * 
 * @author elvin
 *
 */
@Service("articleCatService")
public class ArticleCatServiceImpl implements ArticleCatService {
	@Resource
	ArticleCatMapper articleCatMapper;
	@Override
	public List<ArticleCat> getArticleCatByParas(ArticleCat articleCat, PageBounds pageBounds) throws Exception {
		return articleCatMapper.getArticleCatByParas(articleCat, pageBounds);
	}
	@Override
	public ArticleCat getArticleCatById(Integer id) throws Exception{
		return articleCatMapper.getArticleCatById(id);
	}
	
	@Override
	public List<ArticleCat> getArticleCatByParas(ArticleCat articleCat) throws Exception {
		return articleCatMapper.getArticleCatByParas(articleCat);
	}
	@Override
	public void save(ArticleCat articleCat) throws Exception {
		articleCatMapper.save(articleCat);
	}
	@Override
	public void update(ArticleCat articleCat) throws Exception {
		articleCatMapper.update(articleCat);
	}
	@Override
	public void delete(ArticleCat articleCat) throws Exception {
	}
	@Override
	public List<ArticleCat> getArticleCatsByParasNoPage(ArticleCat articleCat) throws Exception {
		return null;
	}
}
