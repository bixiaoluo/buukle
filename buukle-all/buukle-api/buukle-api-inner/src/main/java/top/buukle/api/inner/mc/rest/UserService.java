/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.api.inner.mc.rest;

import top.buukle.common.request.BaseRequest;
import top.buukle.common.response.BaseResponse;
import top.buukle.daoEntity.mc.entity.User;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * 
 * @author elvin
 *
 */
@Path("/api/inner/mc/user")
@Produces({MediaType.APPLICATION_JSON })
@Consumes({MediaType.APPLICATION_JSON })
public interface UserService {
	
	/** 
	 * @Description:	分页获取User
	 * @param user
	 * @param pageBounds
	 * @return
	 * @return	List<User>
	 * @Date	2015年6月12日 上午10:29:17 
	 */
	 List<User> getUserByParas(User user, PageBounds pageBounds) throws Exception;
	
	/** 
	 * @Description:	根据id获取User
	 * @param
	 * @return
	 * @throws Exception
	 * @return	User
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	@GET
	@Path("/getUserById/{id}")
	 BaseResponse getUserById(@PathParam("id") Integer id) throws Exception;

	@POST
	@Path("/getUserById")
	 BaseResponse getUserById( BaseRequest request) throws Exception;

	/** 
	 * @Description:	根据条件获取User
	 * @param user
	 * @return
	 * @throws Exception
	 * @return	User
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	 List<User> getUserByParas(User user) throws Exception;
	/** 
	 * @Description:	添加User
	 * @param user
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	 void save(User user) throws Exception;
	/** 
	 * @Description:	更新User
	 * @param user
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	 void update(User user) throws Exception;
	/** 
	 * @Description:	删除User
	 * @param user
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	 void delete(User user) throws Exception;
	/** 
	 * @Description:	获取User信息 不带分页
	 * @param user
	 * @return
	 * @throws Exception
	 * @return	List<User>
	 * @Date	2015年6月12日 上午10:30:13 
	 */
	 List<User> getUsersByParasNoPage(User user) throws Exception;


    @POST
    @Path("/getUserInfoForLogin")
    BaseResponse getUserInfoForLogin( BaseRequest request) throws Exception;

}
