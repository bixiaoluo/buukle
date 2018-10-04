/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.mc.service.impl;

import top.buukle.api.inner.mc.ArticleInfoService;
import top.buukle.daoEntity.mc.dao.ArticleInfoMapper;
import top.buukle.daoEntity.mc.entity.ArticleInfo;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 
 * @author elvin
 *
 */
@Service("articleInfoService")
public class ArticleInfoServiceImpl implements ArticleInfoService {
	@Resource
	ArticleInfoMapper articleInfoMapper;
	@Override
	public List<ArticleInfo> getArticleInfoByParas(ArticleInfo articleInfo, PageBounds pageBounds) throws Exception {
		return articleInfoMapper.getArticleInfoByParas(articleInfo, pageBounds);
	}
	@Override
	public ArticleInfo getArticleInfoById(Integer id) throws Exception{
		return articleInfoMapper.getArticleInfoById(id);
	}
	
	@Override
	public List<ArticleInfo> getArticleInfoByParas(ArticleInfo articleInfo) throws Exception {
		return articleInfoMapper.getArticleInfoByParas(articleInfo);
	}
	@Override
	public void save(ArticleInfo articleInfo) throws Exception {
		articleInfoMapper.save(articleInfo);
	}
	@Override
	public void update(ArticleInfo articleInfo) throws Exception {
		articleInfoMapper.update(articleInfo);
	}
	@Override
	public void delete(ArticleInfo articleInfo) throws Exception {
	}
	@Override
	public List<ArticleInfo> getArticleInfosByParasNoPage(ArticleInfo articleInfo) throws Exception {
		return null;
	}
}
