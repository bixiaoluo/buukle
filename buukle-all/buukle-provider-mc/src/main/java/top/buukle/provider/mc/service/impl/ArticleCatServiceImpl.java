/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.mc.service.impl;

import top.buukle.api.inner.mc.ArticleCatService;
import top.buukle.daoEntity.mc.dao.ArticleCatMapper;
import top.buukle.daoEntity.mc.entity.ArticleCat;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
