package top.buukle.plugin.security.configure;

import top.buukle.common.util.logger.BaseLogger;

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


}
