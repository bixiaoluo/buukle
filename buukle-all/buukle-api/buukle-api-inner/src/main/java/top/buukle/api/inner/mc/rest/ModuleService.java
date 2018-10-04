/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.api.inner.mc.rest;

import top.buukle.common.request.BaseRequest;
import top.buukle.common.response.BaseResponse;
import top.buukle.daoEntity.mc.entity.Module;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * 
 * @author elvin
 *
 */
@Path("/api/inner/mc/module")
@Produces({MediaType.APPLICATION_JSON })
@Consumes({MediaType.APPLICATION_JSON })
public interface ModuleService {
	
	/** 
	 * @Description:	分页获取Module
	 * @param module
	 * @param pageBounds
	 * @return
	 * @return	List<Module>
	 * @Date	2015年6月12日 上午10:29:17 
	 */
	public List<Module> getModuleByParas(Module module, PageBounds pageBounds) throws Exception;
	
	/** 
	 * @Description:	根据id获取Module
	 * @param
	 * @return
	 * @throws Exception
	 * @return	Module
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public Module getModuleById(Integer id) throws Exception;
	
	/** 
	 * @Description:	根据条件获取Module
	 * @param module
	 * @return
	 * @throws Exception
	 * @return	Module
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public List<Module> getModuleByParas(Module module) throws Exception;
	/** 
	 * @Description:	添加Module
	 * @param module
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	public void save(Module module) throws Exception;
	/** 
	 * @Description:	更新Module
	 * @param module
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	public void update(Module module) throws Exception;
	/** 
	 * @Description:	删除Module
	 * @param module
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	public void delete(Module module) throws Exception;
	/** 
	 * @Description:	获取Module信息 不带分页
	 * @param module
	 * @return
	 * @throws Exception
	 * @return	List<Module>
	 * @Date	2015年6月12日 上午10:30:13 
	 */
	public List<Module> getModulesByParasNoPage(Module module) throws Exception;


    /**
     * 获取全局菜单列表
     * @param request
     * @return
     * @throws Exception
     */
    @POST
    @Path("/getGlobalModuleList")
    BaseResponse getGlobalModuleList(BaseRequest request) throws Exception;

    /**
     * 获取用户菜单列表
     * @param request
     * @return
     * @throws Exception
     */
    @POST
    @Path("/getUserModuleList")
    BaseResponse getUserModuleList(BaseRequest request) throws Exception;


}
