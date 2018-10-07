package top.buukle.provider.mc.configure;


import feign.Request;
import feign.Retryer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import top.buukle.common.filter.reqestAndResponseParameterFilter.BaseRequestParamValidateFilter;
import top.buukle.common.filter.reqestAndResponseParameterFilter.BaseResponseParamHandlerFilter;
import top.buukle.common.util.common.NumberUtil;
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


    /** feign-http 链接超時時間*/
    public static int connectTimeOutMillis = NumberUtil.INTEGER_THOUSAND * NumberUtil.INTEGER_THREE;
    /** feign-http 等待超时时间*/
    public static int readTimeOutMillis = NumberUtil.INTEGER_THOUSAND * NumberUtil.INTEGER_SIX;

    /**
     * 重写静态资源处理
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/static/");
    }

    /**
     * 注册 feign-http 超时设置实体
     * @return
     */
    @Bean
    public Request.Options options() {
        return new Request.Options(connectTimeOutMillis, readTimeOutMillis);
    }

    /**
     * 注册 feign-http 重试机制设置实体
     * @return
     */
    @Bean
    public Retryer feignRetryer() {
        //超时后每隔200ms ~ 2000ms 重试一次,最多重试0次;
        return new Retryer.Default(200,2000,0);
    }

    /**
     * 注册 全局api请求参数校验 过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean1() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new BaseRequestParamValidateFilter());
        registration.addUrlPatterns("/api/*");
        registration.setName("BaseRequestParamValidateFilter");
        registration.setOrder(1);
        return registration;
    }
    /**
     * 注册 全局api返回参数校验 过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean2() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new BaseResponseParamHandlerFilter());
        registration.addUrlPatterns("/api/*");
        registration.setName("BaseResponseParamHandlerFilter");
        registration.setOrder(2);
        return registration;
    }
}
