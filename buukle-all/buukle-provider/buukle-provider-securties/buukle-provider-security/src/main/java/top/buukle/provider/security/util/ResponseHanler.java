package top.buukle.provider.security.util;

import com.alibaba.fastjson.JSON;
import top.buukle.common.filter.reqestAndResponseParameterFilter.validatorAndHandler.base.BaseResponseParamHandler;
import top.buukle.common.filter.reqestAndResponseParameterFilter.wrapper.BaseResponseWrapper;
import top.buukle.common.response.BaseResponse;

import java.io.IOException;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/7.
 * @Description :
 */
public class ResponseHanler extends BaseResponseParamHandler {

    /**
     * 重写处理方法
     * @param baseResponseWrapper
     */
    @Override
    protected void doHandle(BaseResponseWrapper baseResponseWrapper) throws IOException {
        String responseBody = baseResponseWrapper.getResponseBody();
        BaseResponse baseResponse = JSON.parseObject(responseBody, BaseResponse.class);
        baseResponse.setMsg(baseResponse.getMsg()+"--");
        this.afterHandle(baseResponseWrapper,JSON.toJSONString(baseResponse));
    }
}
