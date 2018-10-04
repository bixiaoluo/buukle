package top.buukle.common.exception;

import top.buukle.common.response.BaseResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/1.
 * @Description : springboot 应用全局异常解决方案
 */
@ControllerAdvice
public class GlobalExceptionHandler {


    /** 系统异常计数器*/
    public static AtomicLong ERROR_COUNT = new AtomicLong(0L);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public BaseResponse globalExceptionHandler(Exception e) {
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
    private BaseResponse BaseExceptionHandle(Exception e) {
        BaseException baseException = (BaseException) e;
        baseException.printStackTrace();
        return new BaseResponse.Builder().buildFailedInner(baseException);
    }

    /**
     * 系统异常处理
     * @return
     * @param e
     */
    private BaseResponse exceptionHandle(Exception e) {
        e.printStackTrace();
        return new BaseResponse.Builder().buildFailedInner(ERROR_COUNT);
    }
}
