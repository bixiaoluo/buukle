package top.buukle.plugin.sso.constants;

import top.buukle.plugin.sso.plugins.AuthAndPermInterceptor;
import top.buukle.plugin.sso.vo.ViewNameParameters;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/8/30.
 * @Description :
 */
public class Constants {


    /*----------------------------------------系统设置---------------------------------------------------------*/
    /** 系统登录cookie key*/
    public static final String COOKIE_LOGIN_KEY = "ELOG";

    /*------------------------------------用户自定义设置-------------------------------------------------------*/
    /** 用户登录关闭验证码*/
    public static final String CLOSE_VERIFY_TRUE = "1";
    /** 用户获取session中验证码的key前缀*/
    public static final String VERIFY_CODE_KEY_PREFIX = "VERIFY_CODE_KEY_PREFIX_";
    /** 开启认证*/
    public static final String OPEN_AUTH_TRUE = "1";
    /** 关闭认证*/
    public static final String OPEN_AUTH_FALSE = "0";

    /*-----------------------------------系统返回--------------------------------------------------------------------*/
    /** 没有cookie,未登录*/
    public static final String NO_LOGIN = AuthAndPermInterceptor.LOGIN_PATH;
    /** 认证失败*/
    public static final String NO_AUTHENTICATION_WORD = "登录超时，请重新登陆 ！";
    /** 没有权限*/
    public static final String NO_PERMISSION_WORD = "抱歉！您无此操作权限！请联系网站管理员！";

    /*-----------------------------------常量设置--------------------------------------------------------------------*/

    public static final String LOGIN_PATH_ENVIRONMENT_KEY = "LOGIN_PATH_ENVIRONMENT_KEY";
    public static final String INDEX_PATH_ENVIRONMENT_KEY = "INDEX_PATH_ENVIRONMENT_KEY";
    public static final String OUT_OF_TIME_PATH_LOGIN_PATH_ENVIRONMENT_KEY = "OUT_OF_TIME_PATH_LOGIN_PATH_ENVIRONMENT_KEY";
    public static final String NO_PERMISSION_PATH_ENVIRONMENT_KEY = "NO_PERMISSION_PATH_ENVIRONMENT_KEY";
    public static final String ERROR_PAGE_PATH_ENVIRONMENT_KEY = "ERROR_PAGE_PATH_ENVIRONMENT_KEY";
    public static final String LOGOUT_PATH_ENVIRONMENT_KEY = "LOGOUT_PATH_ENVIRONMENT_KEY";

    public static final String LOGIN_VIEW_NAME_ENVIRONMENT_KEY = "LOGIN_VIEW_NAME_ENVIRONMENT_KEY";
    public static final String INDEX_VIEW_NAME_ENVIRONMENT_KEY = "INDEX_VIEW_NAME_ENVIRONMENT_KEY";
    public static final String OUT_OF_TIME_VIEW_NAME_ENVIRONMENT_KEY = "OUT_OF_TIME_VIEW_NAME_ENVIRONMENT_KEY";
    public static final String NO_PERMISSION_VIEW_NAME_ENVIRONMENT_KEY = "NO_PERMISSION_VIEW_NAME_ENVIRONMENT_KEY";
    public static final String ERROR_PAGE_VIEW_NAME_ENVIRONMENT_KEY = "ERROR_PAGE_VIEW_NAME_ENVIRONMENT_KEY";
    public static final String LOGOUT_VIEW_NAME_ENVIRONMENT_KEY = "LOGOUT_VIEW_NAME_ENVIRONMENT_KEY";

    /** 指定视图包装对象 (通过ssoController动态返回用户配置的指定sso视图名称)*/
    public static final ViewNameParameters VIEW_NAME_PARAMETERS = new ViewNameParameters();

    /** 缓存用户指定的sso服务地址*/
    public static final List<String> SSO_HOST = new ArrayList<>();
}
