package top.buukle.plugin.sso.business.impl;

import top.buukle.api.out.sso.entity.User;
import top.buukle.api.out.sso.vo.query.UserLoginPermissionQuery;
import top.buukle.common.constants.BaseResponseCode;
import top.buukle.common.exception.BaseException;
import top.buukle.common.request.BaseRequest;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.util.common.StringUtil;
import top.buukle.plugin.sso.business.LoginOutAndAuthAndPermBusiness;
import top.buukle.plugin.sso.constants.Constants;
import top.buukle.plugin.sso.invoker.LoginOutAndAuthAndPermInvoker;
import top.buukle.plugin.sso.plugins.AuthAndPermInterceptor;
import top.buukle.plugin.sso.util.CookieUtil;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/6/10.
 * @Description :
 */
@Component()
public class LoginOutAndAuthAndPermBusinessImpl implements LoginOutAndAuthAndPermBusiness {

    /**
     * 登录
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    public BaseResponse doLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //关闭验证码
        if(StringUtil.isNotEmpty(AuthAndPermInterceptor.CLOSE_VERIFICATION) && AuthAndPermInterceptor.CLOSE_VERIFICATION.equals(Constants.CLOSE_VERIFY_TRUE)){
            //登录
            return this.doLogin(request, AuthAndPermInterceptor.CACHE_CATEGORY_KEY, AuthAndPermInterceptor.SSO_DEFAULT_AGE, response, AuthAndPermInterceptor.SSO_DOMAIN, AuthAndPermInterceptor.LOGIN_OUT_STRATEGY, AuthAndPermInterceptor.APPLICATION_NAME);
        }
        //开启验证码
        //缓存request验证码
        String requestVerificationCode = request.getParameter(AuthAndPermInterceptor.VERIFICATION_CODE_KEY);
        if(StringUtil.isEmpty(requestVerificationCode)){
            return new BaseResponse.Builder().buildFailedInner(BaseResponseCode.USER_LOGIN_VERIFY_CODE_NULL);
        }
        //缓存session验证码
        String sessionVerificationCode = (String) request.getSession().getAttribute(Constants.VERIFY_CODE_KEY_PREFIX + AuthAndPermInterceptor.VERIFICATION_CODE_KEY);
        //移除session验证码
        request.getSession().removeAttribute(Constants.VERIFY_CODE_KEY_PREFIX+ AuthAndPermInterceptor.VERIFICATION_CODE_KEY);
        //验证码错误
        if(!requestVerificationCode.equals(sessionVerificationCode)){
            return new BaseResponse.Builder().buildFailedInner(BaseResponseCode.USER_LOGIN_VERIFY_CODE_WRONG);
        }
        //登录
        return this.doLogin(request, AuthAndPermInterceptor.CACHE_CATEGORY_KEY, AuthAndPermInterceptor.SSO_DEFAULT_AGE,response, AuthAndPermInterceptor.SSO_DOMAIN, AuthAndPermInterceptor.LOGIN_OUT_STRATEGY, AuthAndPermInterceptor.APPLICATION_NAME);
    }

    /**
     * 登录
     * @param request
     * @param cacheCategoryKey
     * @param ssoDefaultAge
     * @param response
     * @param ssoDomain
     * @param loginOutStrategy
     * @param applicationName
     * @return
     * @throws Exception
     */
    private BaseResponse doLogin(HttpServletRequest request, String cacheCategoryKey, String ssoDefaultAge, HttpServletResponse response, String ssoDomain, String loginOutStrategy, String applicationName) throws Exception {
        //校验参数
        User user = this.validateLoginParam(request,cacheCategoryKey);
        BaseRequest baseRequest = new BaseRequest.Builder().build(applicationName);
        baseRequest.setInfo(user);
        baseRequest.setExpandParameterString(ssoDefaultAge);
        BaseResponse baseResponse = LoginOutAndAuthAndPermInvoker.doLogin(baseRequest);
        //成功,回写cookie
        if(baseResponse ==null){
            return new BaseResponse.Builder().buildFailedInner(BaseResponseCode.USER_AUTHENTICATION_FAILED_REQUEST_WRONG);
        }
        if(baseResponse.isSuccess()){
            String userCookie = (String) baseResponse.getDataWithIndex(String.class,0);
            CookieUtil.addLocalCookieWithAWeekTime(userCookie,response,ssoDomain);
        }
        return baseResponse;
    }

    /**
     * 认证&授权
     * @param request
     * @param response
     * @param uri
     * @param ssoDefaultAge
     * @param applicationName
     * @return
     */
    @Override
    public BaseResponse authAndSetPermission(HttpServletRequest request, HttpServletResponse response, String uri, String ssoDefaultAge,  String applicationName) throws Exception {
        //无cookie
        if(StringUtil.isEmpty(CookieUtil.getUserCookie(request))){
            return new BaseResponse.Builder().buildFailed(Constants.NO_LOGIN);
        }
        //无来源url
        if(StringUtil.isEmpty(request.getHeader(AuthAndPermInterceptor.REQUEST_HEADER_REFEREE)) && !uri.equals(AuthAndPermInterceptor.INDEX_PATH)){
            return new BaseResponse.Builder().buildFailed(Constants.NO_LOGIN);
        }
        //认证
        BaseResponse authResponse = this.authentication(request, ssoDefaultAge, applicationName);
        if(null == authResponse){
            return new BaseResponse.Builder().buildFailedInner(BaseResponseCode.USER_AUTHENTICATION_FAILED_REQUEST_WRONG);
        }
        if(!authResponse.isSuccess()){
            authResponse.setMsg(AuthAndPermInterceptor.NO_AUTHENTICATION_PATH);
            return authResponse;
        }
        //授权
        BaseResponse baseResponse = this.setPermission(uri, request, AuthAndPermInterceptor.APPLICATION_NAME, authResponse);
        if(!baseResponse.isSuccess()){
            baseResponse.setMsg(AuthAndPermInterceptor.NO_PERMISSION_PATH);
        }
        return baseResponse;
    }

    /**
     * 认证
     * @param httpServletRequest
     * @param ssoDefaultAge
     * @param applicationName
     * @return
     */
    private BaseResponse authentication(HttpServletRequest httpServletRequest, String ssoDefaultAge, String applicationName) throws Exception {
        //校验参数
        String userCookie = this.validateAuthenticationParam(httpServletRequest,applicationName);
        BaseRequest baseRequest = new BaseRequest.Builder().build(applicationName);
        baseRequest.setInfo(userCookie);
        baseRequest.setExpandParameterString(ssoDefaultAge);
        return LoginOutAndAuthAndPermInvoker.authentication(baseRequest);
    }

    /**
     * 授权
     * @param uri
     * @param request
     * @param applicationName
     * @param authResponse
     * @return
     */
    private BaseResponse setPermission(String uri, HttpServletRequest request, String applicationName, BaseResponse authResponse) throws Exception {
        BaseRequest baseRequest = new BaseRequest.Builder().build(applicationName);
        UserLoginPermissionQuery userLoginPermissionQuery = new UserLoginPermissionQuery();
        userLoginPermissionQuery.setUrl(uri);
        userLoginPermissionQuery.setUser((User) authResponse.getDataWithIndex(User.class,0));
        userLoginPermissionQuery.setuserCookie(CookieUtil.getUserCookie(request));
        baseRequest.setInfo(userLoginPermissionQuery);
        return LoginOutAndAuthAndPermInvoker.setPermission(baseRequest);
    }

    /**
     * 登出
     * @param request
     * @param response
     */
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response) {

    }

    /**
     * 校验登录参数
     * @param request
     * @param cacheCategoryKey
     * @return
     */
    private User validateLoginParam(HttpServletRequest request, String cacheCategoryKey) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String cacheCategory = request.getParameter(cacheCategoryKey);
        if(StringUtil.isEmpty(username) || StringUtil.isEmpty(password)){
            throw new BaseException(BaseResponseCode.USER_LOGIN_USERNAME_PASSWORD_NULL_SSO_PLUGIN);
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setLoginStrategy(cacheCategory ==null ? 0: Integer.parseInt(cacheCategory));
        return user;
    }
    /**
     * 校验认证参数
     * @param httpServletRequest
     * @param applicationName
     * @return
     */
    private String validateAuthenticationParam(HttpServletRequest httpServletRequest, String applicationName) {
        if(null == httpServletRequest){
            throw new BaseException(BaseResponseCode.BASE_REQUEST_NULL);
        }
        if(StringUtil.isEmpty(applicationName)){
            throw new BaseException(BaseResponseCode.BASE_REQUEST_APPLICATION_NAME_NULL);
        }
        String userCookie = CookieUtil.getUserCookie(httpServletRequest);
        if(StringUtil.isEmpty(userCookie)){
            throw new BaseException(BaseResponseCode.USER_AUTHENTICATION_FAILED_COOKIE_NULL);
        }
        return userCookie;
    }
}
