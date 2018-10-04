package top.buukle.provider.mc.util;

import top.buukle.common.request.BaseRequest;
import org.apache.commons.lang.StringUtils;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/23.
 * @Description :
 */
public class RequestValidation {


    /**
     * 请求参数校验
     * @param baseRequest
     * @return
     */
    public static Boolean validate(BaseRequest baseRequest) {
        if(null == baseRequest || baseRequest.getRequestHead() == null || StringUtils.isEmpty(baseRequest.getRequestHead().getApplicationName())){
            return false;
        }
        return true;
    }
}
