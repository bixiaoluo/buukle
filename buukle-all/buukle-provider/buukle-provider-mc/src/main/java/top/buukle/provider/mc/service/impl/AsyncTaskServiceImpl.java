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
import top.buukle.provider.mc.dao.AsyncTaskMapper;
import top.buukle.provider.mc.entity.AsyncTask;
import top.buukle.provider.mc.service.AsyncTaskService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

/**
 * 
 * @author elvin
 *
 */
@Service("asyncTaskService")
public class AsyncTaskServiceImpl implements AsyncTaskService {
	@Resource
	AsyncTaskMapper asyncTaskMapper;
	@Override
	public List<AsyncTask> getAsyncTaskByParas(AsyncTask asyncTask, PageBounds pageBounds) throws Exception {
		return asyncTaskMapper.getAsyncTaskByParas(asyncTask, pageBounds);
	}
	@Override
	public AsyncTask getAsyncTaskById(Integer id) throws Exception{
		return asyncTaskMapper.getAsyncTaskById(id);
	}
	
	@Override
	public List<AsyncTask> getAsyncTaskByParas(AsyncTask asyncTask) throws Exception {
		return asyncTaskMapper.getAsyncTaskByParas(asyncTask);
	}
	@Override
	public void save(AsyncTask asyncTask) throws Exception {
		asyncTaskMapper.save(asyncTask);
	}
	@Override
	public void update(AsyncTask asyncTask) throws Exception {
		asyncTaskMapper.update(asyncTask);
	}
	@Override
	public void delete(AsyncTask asyncTask) throws Exception {
	}
	@Override
	public List<AsyncTask> getAsyncTasksByParasNoPage(AsyncTask asyncTask) throws Exception {
		return null;
	}
}
