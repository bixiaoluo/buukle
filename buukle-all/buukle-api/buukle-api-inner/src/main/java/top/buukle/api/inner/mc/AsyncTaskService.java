/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.api.inner.mc;

import top.buukle.daoEntity.mc.entity.AsyncTask;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import java.util.List;

/**
 * 
 * @author elvin
 *
 */
public interface AsyncTaskService {
	
	/** 
	 * @Description:	分页获取AsyncTask
	 * @param asyncTask
	 * @param pageBounds
	 * @return
	 * @return	List<AsyncTask>
	 * @Date	2015年6月12日 上午10:29:17 
	 */
	public List<AsyncTask> getAsyncTaskByParas(AsyncTask asyncTask, PageBounds pageBounds) throws Exception;
	
	/** 
	 * @Description:	根据id获取AsyncTask
	 * @param
	 * @return
	 * @throws Exception
	 * @return	AsyncTask
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public AsyncTask getAsyncTaskById(Integer id) throws Exception;
	
	/** 
	 * @Description:	根据条件获取AsyncTask
	 * @param asyncTask
	 * @return
	 * @throws Exception
	 * @return	AsyncTask
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public List<AsyncTask> getAsyncTaskByParas(AsyncTask asyncTask) throws Exception;
	/** 
	 * @Description:	添加AsyncTask
	 * @param asyncTask
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	public void save(AsyncTask asyncTask) throws Exception;
	/** 
	 * @Description:	更新AsyncTask
	 * @param asyncTask
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	public void update(AsyncTask asyncTask) throws Exception;
	/** 
	 * @Description:	删除AsyncTask
	 * @param asyncTask
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	public void delete(AsyncTask asyncTask) throws Exception;
	/** 
	 * @Description:	获取AsyncTask信息 不带分页
	 * @param asyncTask
	 * @return
	 * @throws Exception
	 * @return	List<AsyncTask>
	 * @Date	2015年6月12日 上午10:30:13 
	 */
	public List<AsyncTask> getAsyncTasksByParasNoPage(AsyncTask asyncTask) throws Exception;
	

}
