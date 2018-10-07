package top.buukle.provider.security.util;

import com.alibaba.fastjson.JSON;
import top.buukle.common.constants.BaseResponseCode;
import top.buukle.common.filter.reqestAndResponseParameterFilter.validatorAndHandler.base.BaseRequestValidator;
import top.buukle.common.request.BaseRequest;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.util.common.StringUtil;
import top.buukle.common.util.logger.BaseLogger;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/7.
 * @Description : 继承 BaseRequestValidator 自定义参数检验规则和异常返回response信息
 */
public class RequestValidator extends BaseRequestValidator {


    private static final BaseLogger LOGGER = BaseLogger.getLogger(RequestValidator.class);

    /**
     * 重写参数校验方法
     * @param httpServletRequest
     * @param uri
     * @param requestBody
     * @param servletResponse
     */
    @Override
    public void doValidate(HttpServletRequest httpServletRequest, String uri, String requestBody, ServletResponse servletResponse) throws IOException {
        try {
            if(!uri.contains("uploadImageServlet")){
                String reqMethod = httpServletRequest.getMethod();
                if("POST".equals(reqMethod)){
                    if(uri.startsWith("/api/")){
                        //校验请求参数
                        BaseResponse baseResponse = this.doValidate(requestBody);
                        //校验失败
                        if(!baseResponse.isSuccess()){
                            this.afterValidateWrong(servletResponse,baseResponse);
                        }else{
                            this.afterValidateHandle(httpServletRequest,requestBody);
                        }
                    }
                }
            }
        }catch (Exception e){
            this.afterValidateWrong(servletResponse,new BaseResponse.Builder().buildFailedOut(BaseResponseCode.BASE_REQUEST_PARSE_INFO_LIST_WRONG));
        }
    }

    /**
     * 重载参数校验方法
     * @param requestBody
     * @return
     */
    private BaseResponse doValidate(String requestBody) {
        BaseRequest baseRequest = JSON.parseObject(requestBody, BaseRequest.class);
        if(null == baseRequest || baseRequest.getRequestHead() == null ||
                StringUtil.isEmpty(baseRequest.getRequestHead().getApplicationName()) ||
                StringUtil.isEmpty(baseRequest.getRequestHead().getOperationLoginName()) ||
                StringUtil.isEmpty(baseRequest.getRequestHead().getOperationId()) ||
                baseRequest.getRequestHead().getOperationDatetime() == null){
            LOGGER.info(BaseResponseCode.BASE_REQUEST_NULL.getMsg());
            return new BaseResponse.Builder().buildFailedOut(BaseResponseCode.BASE_REQUEST_NULL);
        }
        return new BaseResponse.Builder().buildSuccess();
    }

}
