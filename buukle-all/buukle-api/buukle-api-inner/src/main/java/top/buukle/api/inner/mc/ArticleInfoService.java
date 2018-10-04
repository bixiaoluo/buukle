/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.api.inner.mc;

import top.buukle.daoEntity.mc.entity.ArticleInfo;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import java.util.List;

/**
 * 
 * @author elvin
 *
 */
public interface ArticleInfoService {
	
	/** 
	 * @Description:	分页获取ArticleInfo
	 * @param articleInfo
	 * @param pageBounds
	 * @return
	 * @return	List<ArticleInfo>
	 * @Date	2015年6月12日 上午10:29:17 
	 */
	public List<ArticleInfo> getArticleInfoByParas(ArticleInfo articleInfo, PageBounds pageBounds) throws Exception;
	
	/** 
	 * @Description:	根据id获取ArticleInfo
	 * @param
	 * @return
	 * @throws Exception
	 * @return	ArticleInfo
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public ArticleInfo getArticleInfoById(Integer id) throws Exception;
	
	/** 
	 * @Description:	根据条件获取ArticleInfo
	 * @param articleInfo
	 * @return
	 * @throws Exception
	 * @return	ArticleInfo
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public List<ArticleInfo> getArticleInfoByParas(ArticleInfo articleInfo) throws Exception;
	/** 
	 * @Description:	添加ArticleInfo
	 * @param articleInfo
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	public void save(ArticleInfo articleInfo) throws Exception;
	/** 
	 * @Description:	更新ArticleInfo
	 * @param articleInfo
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	public void update(ArticleInfo articleInfo) throws Exception;
	/** 
	 * @Description:	删除ArticleInfo
	 * @param articleInfo
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	public void delete(ArticleInfo articleInfo) throws Exception;
	/** 
	 * @Description:	获取ArticleInfo信息 不带分页
	 * @param articleInfo
	 * @return
	 * @throws Exception
	 * @return	List<ArticleInfo>
	 * @Date	2015年6月12日 上午10:30:13 
	 */
	public List<ArticleInfo> getArticleInfosByParasNoPage(ArticleInfo articleInfo) throws Exception;
	

}
