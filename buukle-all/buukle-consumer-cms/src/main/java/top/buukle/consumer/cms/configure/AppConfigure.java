package top.buukle.consumer.cms.configure;


import top.buukle.plugin.sso.configure.PluginSsoConfigure;
import top.buukle.plugin.sso.plugins.AuthAndPermInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/23.
 * @Description : AppConfigure Mvc系统配置类
 */
@Configuration
public class AppConfigure implements WebMvcConfigurer {

    /**
     * 放行静态资源
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/static/");
    }

    /** 注册拦截器插件实体*/
    @Bean
    AuthAndPermInterceptor getAuthAndPermInterceptor() {
        return new AuthAndPermInterceptor(PluginSsoConfigure.parameters);
    }

    /**
     * 配置插入sso拦截器插件
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getAuthAndPermInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/static/**")
                //放行錯誤請求
                .excludePathPatterns("/error")
                //放行静态资源
        ;
    }
}
