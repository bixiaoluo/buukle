package top.buukle.plugin.sso.invoker;

import com.alibaba.fastjson.JSON;
import top.buukle.common.request.BaseRequest;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.util.logger.BaseLogger;
import top.buukle.plugin.sso.util.HttpUtil;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/1.
 * @Description : 登录登出认证授权 执行层对象
 */
public class LoginOutAndAuthAndPermInvoker {

    final private static BaseLogger LOGGER = BaseLogger.getLogger(LoginOutAndAuthAndPermInvoker.class);

    public static BaseResponse doLogin(BaseRequest request) throws Exception {
        LOGGER.info("调用sso:{}接口,执行登陆,请求:{}", HttpUtil.METHOD_URL_MAP.get(HttpUtil.METHOD_SSO_PLUGIN_USER_DO_LOGIN), JSON.toJSONString(request));
        BaseResponse response = HttpUtil.invoker(HttpUtil.METHOD_SSO_PLUGIN_USER_DO_LOGIN, JSON.toJSONString(request));
        LOGGER.info("调用sso:{}接口,执行登陆,返回:{}",HttpUtil.METHOD_URL_MAP.get(HttpUtil.METHOD_SSO_PLUGIN_USER_DO_LOGIN),JSON.toJSONString(response));
        return response;
    }

    public static BaseResponse authentication(BaseRequest request) throws Exception {
        LOGGER.info("调用sso:{}接口,执行认证,请求:{}", HttpUtil.METHOD_URL_MAP.get(HttpUtil.METHOD_SSO_PLUGIN_USER_AUTHENTICATION), JSON.toJSONString(request));
        BaseResponse response = HttpUtil.invoker(HttpUtil.METHOD_SSO_PLUGIN_USER_AUTHENTICATION, JSON.toJSONString(request));
        LOGGER.info("调用sso:{}接口,执行认证,返回:{}",HttpUtil.METHOD_URL_MAP.get(HttpUtil.METHOD_SSO_PLUGIN_USER_AUTHENTICATION),JSON.toJSONString(response));
        return response;
    }

    public static BaseResponse setPermission(BaseRequest baseRequest) throws Exception {
//        LOGGER.info("调用sso:{}接口,执行授权,请求:{}", HttpUtil.METHOD_URL_MAP.get(HttpUtil.METHOD_SSO_PLUGIN_USER_SET_PERMISSION), JSON.toJSONString(baseRequest));
        BaseResponse response = HttpUtil.invoker(HttpUtil.METHOD_SSO_PLUGIN_USER_SET_PERMISSION, JSON.toJSONString(baseRequest));
//        LOGGER.info("调用sso:{}接口,执行授权,返回:{}",HttpUtil.METHOD_URL_MAP.get(HttpUtil.METHOD_SSO_PLUGIN_USER_SET_PERMISSION),JSON.toJSONString(response));
        return response;
    }
}
