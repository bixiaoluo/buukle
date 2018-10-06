package top.buukle.provider.mc.intercepter;

import top.buukle.common.util.logger.BaseLogger;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/23.
 * @Description :
 */
public class GlobalInterceptor implements HandlerInterceptor {

    private static final BaseLogger LOGGER = BaseLogger.getLogger(GlobalInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        LOGGER.info("请求参数为{}", buffer.toString());
//        LOGGER.info("请求参数Map为{}", reqMap);
//        LOGGER.info("请求头部Map为{}", headerMap);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }
}
