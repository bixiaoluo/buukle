package top.buukle.provider.mc.intercepter;

import top.buukle.common.util.common.IoUtil;
import top.buukle.common.util.logger.BaseLogger;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/23.
 * @Description :
 */
public class GlobalParamInterceptor implements HandlerInterceptor {

    private static final BaseLogger LOGGER = BaseLogger.getLogger(GlobalParamInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LOGGER.info("请求:{}接口开始",request.getRequestURI());
        String body = IoUtil.read(new BufferedReader(new InputStreamReader(request.getInputStream())));
        LOGGER.info("请求参数为{}",body);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }
}
