package top.buukle.common.filter.reqestAndResponseParameterFilter.validatorAndHandler.base;

import top.buukle.common.filter.reqestAndResponseParameterFilter.wrapper.BaseResponseWrapper;
import top.buukle.common.util.logger.BaseLogger;

import java.io.IOException;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/7.
 * @Description :
 */
public abstract class BaseResponseParamHandler {


    private static final BaseLogger LOGGER = BaseLogger.getLogger(BaseResponseParamHandler.class);

    /**
     * 返回参数处理入口
     * @param baseResponseWrapper
     */
    public void handle(BaseResponseWrapper baseResponseWrapper) throws IOException {
        this.preHandle(baseResponseWrapper);
        this.doHandle(baseResponseWrapper);
    }

    /**
     * 返回参数预处理
     * @param baseResponseWrapper
     */
    public void preHandle(BaseResponseWrapper baseResponseWrapper){
        this.logger(baseResponseWrapper,true);
    }

    /**
     * 执行返回参数处理抽象方法
     * @param baseResponseWrapper
     */
    protected abstract void doHandle(BaseResponseWrapper baseResponseWrapper) throws IOException;

    /**
     * 参数处理后写回response包装类
     * @param baseResponseWrapper
     */
    public void afterHandle(BaseResponseWrapper baseResponseWrapper,String handledResponseBody) throws IOException {
        this.logger(baseResponseWrapper,false);
        baseResponseWrapper.getOutputStream().write(handledResponseBody.getBytes());
    }

    private void logger(BaseResponseWrapper baseResponseWrapper, boolean isPre) {
        LOGGER.info("BaseResponseParamHandler.preHandle():处理" + (isPre ? "前": "后") +"的返回参数 :{} ",baseResponseWrapper.getResponseBody());
    }
}
