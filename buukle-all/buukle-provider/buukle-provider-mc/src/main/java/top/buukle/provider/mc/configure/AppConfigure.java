package top.buukle.provider.mc.configure;


import top.buukle.provider.mc.intercepter.GlobalParamInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/23.
 * @Description :
 */
@Configuration
public class AppConfigure implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new GlobalParamInterceptor());
    }
}
