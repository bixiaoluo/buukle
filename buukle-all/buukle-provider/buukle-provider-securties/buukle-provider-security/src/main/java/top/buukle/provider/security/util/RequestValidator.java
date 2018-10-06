package top.buukle.provider.security.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import top.buukle.common.constants.BaseResponseCode;
import top.buukle.common.filter.Validator;
import top.buukle.common.request.BaseRequest;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.util.common.StringUtil;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/7.
 * @Description : 继承 Validator 自定义参数检验规则和异常返回response信息
 */
public class RequestValidator extends Validator{


    /**
     * 重写参数校验方法
     * @param body
     * @return
     */
    @Override
    public BaseResponse validate(String body) {
        try {
            BaseRequest baseRequest = JSON.parseObject(body, BaseRequest.class);
            if(null == baseRequest || baseRequest.getRequestHead() == null ||
                    StringUtil.isEmpty(baseRequest.getRequestHead().getApplicationName()) ||
                    StringUtil.isEmpty(baseRequest.getRequestHead().getOperationLoginName()) ||
                    StringUtil.isEmpty(baseRequest.getRequestHead().getOperationId()) ||
                    baseRequest.getRequestHead().getOperationDatetime() == null){
                return new BaseResponse.Builder().buildFailedOut(BaseResponseCode.BASE_REQUEST_NULL);
            }
            return new BaseResponse.Builder().buildSuccess();
        }catch (Exception e){
            return new BaseResponse.Builder().buildFailedOut(BaseResponseCode.BASE_REQUEST_PARSE_INFO_LIST_WRONG);
        }
    }
}
