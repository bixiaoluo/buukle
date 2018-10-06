package top.buukle.plugin.security.configure;


import top.buukle.common.util.common.PropertiesUtil;
import top.buukle.common.util.logger.BaseLogger;
import top.buukle.plugin.security.constants.SecurityConstants;
import top.buukle.plugin.security.vo.LoginParameters;

import java.util.Properties;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/3.
 * @Description : sso插件默认配置类
 */
public class SecurityConfigure {

    private static BaseLogger LOGGER = BaseLogger.getLogger(SecurityConfigure.class);

    /** 系统默认配置文件对象*/
    private static Properties PROPERTIES ;

    /** 指定免授权的路径数组集合*/
    private static final String[] FREE_PERMISSION_PATH_ARRAY = {"/test"};

    /** 初始化sso插件参数包装对象*/
    public static final LoginParameters DEFAULT_PARAMETERS = new LoginParameters(LoginParameters.DEFAULT_FIELD);

    // 灌入sso插件参数包装对象默认属性参数
    static {
        //寻访默认配置文件
        boolean hasDefaultConfigureFile = true;
        try {
            PROPERTIES = PropertiesUtil.getProperties("config/properties/sso.properties");
        }catch (Exception e){
            LOGGER.info("没有找到默认的文件配置 ,地址 : config/properties/sso.properties ... ");
            hasDefaultConfigureFile = false;
        }
        if(null == PROPERTIES ||PROPERTIES.size() < 1){
            hasDefaultConfigureFile = false;
        }
        if(hasDefaultConfigureFile){
            /*---------------------------------------------设置应用相关--------------------------------------------*/
            //设置版本
            DEFAULT_PARAMETERS.version = LoginParameters.DEFAULT_FILE;
            // 应用名
            DEFAULT_PARAMETERS.setApplicationName((String) PROPERTIES.get("sso.applicationName"));
            //sso地址
            DEFAULT_PARAMETERS.setSsoHost((String) PROPERTIES.get("sso.rest.host"));
            // 默认超时时间
            DEFAULT_PARAMETERS.setDefaultMaxAge((String) PROPERTIES.get("sso.defaultMaxAge"));
            // cookie跨域的domain
            DEFAULT_PARAMETERS.setSsoDomain((String) PROPERTIES.get("sso.ssoDomain"));
            // 用户登出策略(1 : 单点登出 0 : 多点登出)
            DEFAULT_PARAMETERS.setLoginOutStrategy((String) PROPERTIES.get("sso.loginOutStrategy"));

        /*-----------------------------------------------设置key-----------------------------------------------*/
            // 获取验证码key
            DEFAULT_PARAMETERS.setVerificationCodeKey((String) PROPERTIES.get("sso.verificationCodeKey"));
            // 用户登录策略key
            DEFAULT_PARAMETERS.setCaCheStrategyKey((String) PROPERTIES.get("sso.caCheStrategyKey"));

        /*-----------------------------------------------设置开关-----------------------------------------------*/
            // 授权开关(1 : 开启 0 : 关闭)
            DEFAULT_PARAMETERS.setOpenAuth((String) PROPERTIES.get("sso.openAuth"));
            // 验证码验证开关(1 : 关闭 无 : 开启)
            DEFAULT_PARAMETERS.setCloseVerification((String) PROPERTIES.get("sso.closeVerification"));

        /*--------------------------------设置指定返回json，stram 等非视图资源的Path 路径---------------------------*/
            // 获取验证码路径
            DEFAULT_PARAMETERS.setVerificationImgPath((String) PROPERTIES.get("sso.verificationImgPath"));
            // 执行登陆路径
            DEFAULT_PARAMETERS.setDoLoginPath((String) PROPERTIES.get("sso.doLoginPath"));
            // 未开启授权应用获取用户信息路径
            DEFAULT_PARAMETERS.setAutoLoginPath((String) PROPERTIES.get("sso.autoLoginPath"));

        /*-------------------------------设置指定跳转视图的Path映射 (requestMapping) 路径---------------------------*/
            // 去往登录页面路径
            DEFAULT_PARAMETERS.setLoginPath((String) PROPERTIES.get("sso.loginPath"));
            // 去往首页页面路径
            DEFAULT_PARAMETERS.setIndexPath((String) PROPERTIES.get("sso.indexPath"));
            // 去往超时页面路径
            DEFAULT_PARAMETERS.setOutOfTimePath((String) PROPERTIES.get("sso.outOfTimePath"));
            // 去往越权页面路径
            DEFAULT_PARAMETERS.setNoPermissionPath((String) PROPERTIES.get("sso.noPermissionPath"));
            // 去往错误页面路径
            DEFAULT_PARAMETERS.setErrorPagePath((String) PROPERTIES.get("sso.errorPagePath"));
            // 去往登出操作路径
            DEFAULT_PARAMETERS.setLogoutPath((String) PROPERTIES.get("sso.logoutPath"));

        /*---------------------------------设置指定跳转视图的Path的跳转视图 (view) 名称------------------------------*/
            // 登录页面跳转视图名
            DEFAULT_PARAMETERS.setLoginViewName((String) PROPERTIES.get("sso.loginViewName"));
            // 首页页面跳转视图名
            DEFAULT_PARAMETERS.setIndexViewName((String) PROPERTIES.get("sso.indexViewName"));
            // 超时页面跳转视图名
            DEFAULT_PARAMETERS.setOutOfTimeViewName((String) PROPERTIES.get("sso.outOfTimeViewName"));
            // 越权页面跳转视图名
            DEFAULT_PARAMETERS.setNoPermissionViewName((String) PROPERTIES.get("sso.noPermissionViewName"));
            // 错误页面跳转视图名
            DEFAULT_PARAMETERS.setErrorPageViewName((String) PROPERTIES.get("sso.errorPageViewName"));
            // 登出完成跳转视图名
            DEFAULT_PARAMETERS.setLogoutViewName((String) PROPERTIES.get("sso.logoutViewName"));

        /*----------------------------------------设置免授权路径数组------------------------------------------------*/
            // 开启授权后，指定免授权的路径数组集合
            DEFAULT_PARAMETERS.setFreePermissionPathList(FREE_PERMISSION_PATH_ARRAY);
            LOGGER.info("buukle-buukle-security 加载默认配置完成 \r\n 文件地址 : config/properties/sso.properties,接入应用名 :{},目标sso服务器地址 :{},ssoDomain : {} ,授权开关 :{}",
                    DEFAULT_PARAMETERS.getApplicationName(),
                    DEFAULT_PARAMETERS.getSsoHost(),
                    DEFAULT_PARAMETERS.getSsoDomain(),
                    DEFAULT_PARAMETERS.getOpenAuth().equals(SecurityConstants.OPEN_AUTH_TRUE) ? "开启": "关闭"
            );
        }
    }
}
