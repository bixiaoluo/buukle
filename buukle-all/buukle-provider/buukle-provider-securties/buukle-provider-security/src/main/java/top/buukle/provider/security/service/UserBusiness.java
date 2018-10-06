package top.buukle.provider.security.service;

import top.buukle.common.request.BaseRequest;
import top.buukle.common.response.BaseResponse;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/5.
 * @Description :
 */
public interface UserBusiness {

    public BaseResponse doLogin(BaseRequest baseRequest) throws Exception;

}
