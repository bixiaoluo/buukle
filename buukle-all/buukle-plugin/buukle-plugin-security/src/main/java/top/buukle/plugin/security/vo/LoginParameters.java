package top.buukle.plugin.security.vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/8/30.
 * @Description :
 */
public class LoginParameters {

    /** 默认属性*/
    public static final String DEFAULT_FIELD = "0";
    /** 配置文件*/
    public static final String DEFAULT_FILE = "1";
    /** 用户自定义属性*/
    public static final String USER_FIELD = "2";

    /** 配置版本*/
    public String version = DEFAULT_FIELD;
    /*---------------------------------------------设置应用相关--------------------------------------------*/

    /** 应用名*/
    private String applicationName = "default applicationName";

    /** sso地址*/
    private String ssoHost = "localHost";

    /** 默认超时时间*/
    private String defaultMaxAge = "300";

    /** cookie跨域的domain*/
    private String ssoDomain = "localhost";

    /** 用户登出策略(1 : 单点登出 0 : 多点登出)*/
    private String loginOutStrategy = "0";
    /*-----------------------------------------------设置key-----------------------------------------------*/

    /** 获取验证码key*/
    private String verificationCodeKey = "verificationCode";

    /** 用户登录策略key*/
    private String caCheStrategyKey = "caCheStrategyKey";

    /*-----------------------------------------------设置开关-----------------------------------------------*/

    /** 授权开关(1 : 开启 0 : 关闭)*/
    private String openAuth = "1";

    /** 验证码验证开关(1 : 关闭 无 : 开启)*/
    private String closeVerification;
    /*--------------------------------设置指定返回json，stram 等非视图资源的Path 路径---------------------------*/

    /** 获取验证码路径*/
    private String verificationImgPath = "/getVerificationImg";

    /** 执行登陆路径*/
    private String doLoginPath = "/doLogin";

    /** 未开启授权应用获取用户信息路径*/
    private String autoLoginPath = "/autoLogin";
    /*-------------------------------设置指定跳转视图的Path映射 (requestMapping) 路径---------------------------*/

    /** 去往登录页面路径*/
    private String loginPath = "/login";

    /** 去往首页页面路径*/
    private String indexPath = "/index";

    /** 去往超时页面路径*/
    private String outOfTimePath = "/outOfTime";

    /** 去往越权页面路径*/
    private String noPermissionPath = "/noPermission";

    /** 去往越权页面路径*/
    private String errorPagePath = "/errors";

    /** 去往登出操作路径*/
    private String logoutPath = "/logout";
    /*---------------------------------设置指定跳转视图的Path的跳转视图 (view) 名称------------------------------*/

    /** 登录页面跳转视图名*/
    private String loginViewName = "login";

    /** 首页页面跳转视图名*/
    private String indexViewName = "index";

    /** 超时页面跳转视图名*/
    private String outOfTimeViewName = "outOfTime";

    /** 越权页面跳转视图名*/
    private String noPermissionViewName = "noPermission";

    /** 错误页面跳转视图名*/
    private String errorPageViewName = "error";

    /** 登出完成跳转视图名*/
    private String logoutViewName = "index";

    /*----------------------------------------设置免授权路径数组------------------------------------------------*/

    /** 开启授权后，指定免授权的路径数组集合*/
    private List<String> freePermissionPathList = new ArrayList<>();
    //end

    public LoginParameters(String version) {
        this.version = version;
    }

    public LoginParameters() {
        this.version = version;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getSsoHost() {
        return ssoHost;
    }

    public void setSsoHost(String ssoHost) {
        this.ssoHost = ssoHost;
    }

    public String getDefaultMaxAge() {
        return defaultMaxAge;
    }

    public void setDefaultMaxAge(String defaultMaxAge) {
        this.defaultMaxAge = defaultMaxAge;
    }

    public String getSsoDomain() {
        return ssoDomain;
    }

    public void setSsoDomain(String ssoDomain) {
        this.ssoDomain = ssoDomain;
    }

    public String getLoginOutStrategy() {
        return loginOutStrategy;
    }

    public void setLoginOutStrategy(String loginOutStrategy) {
        this.loginOutStrategy = loginOutStrategy;
    }

    public String getVerificationCodeKey() {
        return verificationCodeKey;
    }

    public void setVerificationCodeKey(String verificationCodeKey) {
        this.verificationCodeKey = verificationCodeKey;
    }

    public String getCaCheStrategyKey() {
        return caCheStrategyKey;
    }

    public void setCaCheStrategyKey(String caCheStrategyKey) {
        this.caCheStrategyKey = caCheStrategyKey;
    }

    public String getOpenAuth() {
        return openAuth;
    }

    public void setOpenAuth(String openAuth) {
        this.openAuth = openAuth;
    }

    public String getCloseVerification() {
        return closeVerification;
    }

    public void setCloseVerification(String closeVerification) {
        this.closeVerification = closeVerification;
    }

    public String getVerificationImgPath() {
        return verificationImgPath;
    }

    public void setVerificationImgPath(String verificationImgPath) {
        this.verificationImgPath = verificationImgPath;
    }

    public String getDoLoginPath() {
        return doLoginPath;
    }

    public void setDoLoginPath(String doLoginPath) {
        this.doLoginPath = doLoginPath;
    }

    public String getAutoLoginPath() {
        return autoLoginPath;
    }

    public void setAutoLoginPath(String autoLoginPath) {
        this.autoLoginPath = autoLoginPath;
    }

    public String getLoginPath() {
        return loginPath;
    }

    public void setLoginPath(String loginPath) {
        this.loginPath = loginPath;
    }

    public String getIndexPath() {
        return indexPath;
    }

    public void setIndexPath(String indexPath) {
        this.indexPath = indexPath;
    }

    public String getOutOfTimePath() {
        return outOfTimePath;
    }

    public void setOutOfTimePath(String outOfTimePath) {
        this.outOfTimePath = outOfTimePath;
    }

    public String getNoPermissionPath() {
        return noPermissionPath;
    }

    public void setNoPermissionPath(String noPermissionPath) {
        this.noPermissionPath = noPermissionPath;
    }

    public String getLogoutPath() {
        return logoutPath;
    }

    public void setLogoutPath(String logoutPath) {
        this.logoutPath = logoutPath;
    }

    public String getLoginViewName() {
        return loginViewName;
    }

    public void setLoginViewName(String loginViewName) {
        this.loginViewName = loginViewName;
    }

    public String getIndexViewName() {
        return indexViewName;
    }

    public void setIndexViewName(String indexViewName) {
        this.indexViewName = indexViewName;
    }

    public String getOutOfTimeViewName() {
        return outOfTimeViewName;
    }

    public void setOutOfTimeViewName(String outOfTimeViewName) {
        this.outOfTimeViewName = outOfTimeViewName;
    }

    public String getNoPermissionViewName() {
        return noPermissionViewName;
    }

    public void setNoPermissionViewName(String noPermissionViewName) {
        this.noPermissionViewName = noPermissionViewName;
    }

    public String getLogoutViewName() {
        return logoutViewName;
    }

    public String getErrorPagePath() {
        return errorPagePath;
    }

    public void setErrorPagePath(String errorPagePath) {
        this.errorPagePath = errorPagePath;
    }

    public String getErrorPageViewName() {
        return errorPageViewName;
    }

    public void setErrorPageViewName(String errorPageViewName) {
        this.errorPageViewName = errorPageViewName;
    }

    public void setLogoutViewName(String logoutViewName) {
        this.logoutViewName = logoutViewName;
    }

    public List<String> getFreePermissionPathList() {
        return freePermissionPathList;
    }

    public void setFreePermissionPathList(List<String> freePermissionPathList) {
        this.freePermissionPathList = freePermissionPathList;
    }

    public void setFreePermissionPathList(String[] pathArray) {
        this.freePermissionPathList = Arrays.asList(pathArray);
    }

}
