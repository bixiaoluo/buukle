/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.mc.service;
import java.util.List;
import top.buukle.provider.mc.entity.ArticleDesc;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

/**
 * 
 * @author elvin
 *
 */
public interface ArticleDescService {
	
	/** 
	 * @Description:	分页获取ArticleDesc
	 * @param articleDesc
	 * @param pageBounds
	 * @return
	 * @return	List<ArticleDesc>
	 * @Date	2015年6月12日 上午10:29:17 
	 */
	public List<ArticleDesc> getArticleDescByParas(ArticleDesc articleDesc,PageBounds pageBounds) throws Exception;
	
	/** 
	 * @Description:	根据id获取ArticleDesc
	 * @param articleDesc
	 * @return
	 * @throws Exception
	 * @return	ArticleDesc
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public ArticleDesc getArticleDescById(Integer id) throws Exception;
	
	/** 
	 * @Description:	根据条件获取ArticleDesc
	 * @param articleDesc
	 * @return
	 * @throws Exception
	 * @return	ArticleDesc
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public List<ArticleDesc> getArticleDescByParas(ArticleDesc articleDesc) throws Exception;
	/** 
	 * @Description:	添加ArticleDesc
	 * @param articleDesc
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	public void save(ArticleDesc articleDesc) throws Exception;
	/** 
	 * @Description:	更新ArticleDesc
	 * @param articleDesc
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	public void update(ArticleDesc articleDesc) throws Exception;
	/** 
	 * @Description:	删除ArticleDesc
	 * @param articleDesc
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	public void delete(ArticleDesc articleDesc) throws Exception;
	/** 
	 * @Description:	获取ArticleDesc信息 不带分页
	 * @param articleDesc
	 * @return
	 * @throws Exception
	 * @return	List<ArticleDesc>
	 * @Date	2015年6月12日 上午10:30:13 
	 */
	public List<ArticleDesc> getArticleDescsByParasNoPage(ArticleDesc articleDesc) throws Exception;
	

}
