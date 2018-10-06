package top.buukle.provider.security.filter;

import top.buukle.common.util.logger.BaseLogger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/6.
 * @Description :
 */
public class GlobalParameterValidateFilter implements Filter{

    private static final BaseLogger LOGGER = BaseLogger.getLogger(GlobalParameterValidateFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String uri = httpServletRequest.getRequestURI();
        if(uri.contains("uploadImageServlet")){
            //图像上传的请求，不做处理
            filterChain.doFilter(servletRequest, servletResponse);
        }else{
            String reqMethod = httpServletRequest.getMethod();
            if("POST".equals(reqMethod)){
                if(uri.startsWith("/api")){
                    GlobalParameterValidateRequestWrapper globalParameterValidateRequestWrapper = new GlobalParameterValidateRequestWrapper(httpServletRequest);
                    String body = globalParameterValidateRequestWrapper.getBody();
                    LOGGER.info("来源 :{},请求接口方法:{}开始",httpServletRequest.getRemoteAddr(),httpServletRequest.getRequestURI());
                    LOGGER.info("请求参数 :{}",body);
                    filterChain.doFilter(globalParameterValidateRequestWrapper, servletResponse);
                }else{
                    filterChain.doFilter(servletRequest, servletResponse);
                }
            }else{
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
