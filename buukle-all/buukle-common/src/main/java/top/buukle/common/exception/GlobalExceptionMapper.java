package top.buukle.common.exception;

import javax.ws.rs.ext.ExceptionMapper;
import  javax.ws.rs.core.Response;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/1.
 * @Description : dubbox restful 全局异常解决方案
 */
public class GlobalExceptionMapper implements ExceptionMapper<Exception> {

    private static final String APPLICATION_JSON_UTF_8 = "application/json";
    /** 系统异常计数器*/
    public static AtomicLong ERROR_COUNT = new AtomicLong(0L);
    @Override
    public Response toResponse(Exception e) {

        if(e instanceof BaseException){
            return this.BaseExceptionHandle(e);
        }
        return this.exceptionHandle(e);
    }

    /**
     * 自定义异常处理
     * @param e
     * @return
     */
    private Response BaseExceptionHandle(Exception e) {
        BaseException baseException = (BaseException) e;
        baseException.printStackTrace();
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(baseException.getMsg()).type(APPLICATION_JSON_UTF_8).build();
    }

    /**
     * 系统异常处理
     * @return
     * @param e
     */
    private Response exceptionHandle(Exception e) {
        ERROR_COUNT.incrementAndGet() ;
        e.printStackTrace();
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("系统异常!-->"+ERROR_COUNT).type(APPLICATION_JSON_UTF_8).build();
    }
}
