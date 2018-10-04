package top.buukle.api.out.sso.rest;

import top.buukle.common.request.BaseRequest;
import top.buukle.common.response.BaseResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/20.
 * @Description : 用户sso rest API 接口类
 */
@Path("/api/out/sso")
@Produces({MediaType.APPLICATION_JSON })
@Consumes({MediaType.APPLICATION_JSON })
public interface UserSsoBusiness {
    /**
     * restful 测试redis String set API
     * @param key
     * @param value
     */
    @Path("/addStr/{key}/{value}")
    @GET
    void addStr(@PathParam("key") String key, @PathParam("value")String value);

    /**
     * restful 测试redis String get API
     * @param key
     * @return
     */
    @Path("/getStr/{key}")
    @GET
    String getStr(@PathParam("key") String key);


    /**
     * 用户登录
     * @param baseRequest
     * @return
     */
    @Path("/login")
    @POST
    BaseResponse login(BaseRequest baseRequest) throws Exception;

    /**
     * 用户认证
     * @param baseRequest
     * @return
     */
    @Path("/authentication")
    @POST
    BaseResponse authentication(BaseRequest baseRequest);

    /**
     * 用户授权
     * @param baseRequest
     * @return
     */
    @Path("/setPermission")
    @POST
    BaseResponse setPermission(BaseRequest baseRequest) throws Exception;
}
