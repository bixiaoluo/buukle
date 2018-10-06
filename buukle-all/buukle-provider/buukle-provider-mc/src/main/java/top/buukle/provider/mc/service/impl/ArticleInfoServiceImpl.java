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
import top.buukle.provider.mc.dao.ArticleInfoMapper;
import top.buukle.provider.mc.entity.ArticleInfo;
import top.buukle.provider.mc.service.ArticleInfoService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

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

	/**
	 * 根据文章id获取文章内容
     * @param id
	 * @return
	 */
	@Override
	public ArticleInfo getArticleInfoService(Integer id) throws Exception {
        return articleInfoMapper.getArticleInfoById(id);
	}
}
