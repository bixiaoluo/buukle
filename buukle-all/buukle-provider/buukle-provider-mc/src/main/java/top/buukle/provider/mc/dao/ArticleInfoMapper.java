/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.mc.dao;

import top.buukle.provider.mc.entity.ArticleInfo;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
/**
 * 
 * @author elvin
 *
 */

public interface ArticleInfoMapper {
	/** 
	 * @Description:	分页获取ArticleInfo
	 * @param articleInfo
	 * @param pageBounds
	 * @return
	 * @return	PageList<ArticleInfo>
	 * @Date	2015年6月12日 上午10:29:17 
	 */
	public PageList<ArticleInfo> getArticleInfoByParas(ArticleInfo articleInfo,PageBounds pageBounds) throws Exception;
	
	/** 
	 * @Description:	根据id获取ArticleInfo
	 * @param articleInfo
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
	public PageList<ArticleInfo> getArticleInfoByParas(ArticleInfo articleInfo) throws Exception;
	/** 
	 * @Description:	添加ArticleInfo
	 * @param articleInfo
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	public Integer save(ArticleInfo articleInfo) throws Exception;
	/** 
	 * @Description:	更新ArticleInfo
	 * @param articleInfo
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	public Integer update(ArticleInfo articleInfo) throws Exception;
	/** 
	 * @Description:	删除ArticleInfo
	 * @param articleInfo
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	public Integer delete(ArticleInfo articleInfo) throws Exception;
	/** 
	 * @Description:	获取ArticleInfo信息 不带分页
	 * @param articleInfo
	 * @return
	 * @throws Exception
	 * @return	PageList<ArticleInfo>
	 * @Date	2015年6月12日 上午10:30:13 
	 */
	public PageList<ArticleInfo> getArticleInfosByParasNoPage(ArticleInfo articleInfo) throws Exception;
}
