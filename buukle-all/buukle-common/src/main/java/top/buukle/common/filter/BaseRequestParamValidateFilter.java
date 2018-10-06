package top.buukle.common.filter;

import com.alibaba.fastjson.JSON;
import top.buukle.common.constants.BaseResponseCode;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.util.logger.BaseLogger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/6.
 * @Description :
 */
public class BaseRequestParamValidateFilter implements Filter{

    private static final BaseLogger LOGGER = BaseLogger.getLogger(BaseRequestParamValidateFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    private Validator validator;

    public BaseRequestParamValidateFilter(Validator validator){
        this.validator = validator;
    }

    public BaseRequestParamValidateFilter(){
        this.validator = new DefaultValidator();
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
                    //包装请求.处理请求参数
                    BaseRequestWrapper baseRequestWrapper = new BaseRequestWrapper(httpServletRequest);
                    String requestBody = baseRequestWrapper.getBody();
                    LOGGER.info("来源 :{},请求接口方法:{}开始",httpServletRequest.getRemoteAddr(),httpServletRequest.getRequestURI());
                    LOGGER.info("请求参数 :{}",requestBody);
                    BaseResponse baseResponse = validator.validate(requestBody);
                    String userJson;
                    boolean success = (null!=baseResponse && baseResponse.isSuccess());
                    //校验成功
                    if(success){
                        filterChain.doFilter(baseRequestWrapper, servletResponse);
                    }
                    //校验失败
                    else{
                        servletResponse.setContentType("application/json; charset=utf-8");
                        servletResponse.setCharacterEncoding("UTF-8");
                        userJson = null == baseResponse ?  JSON.toJSONString(new BaseResponse.Builder().buildFailedOut(BaseResponseCode.BASE_REQUEST_NULL)) : JSON.toJSONString(baseResponse);
                        LOGGER.info("返回参数 :{} ",userJson);
                        ServletOutputStream outputStream = servletResponse.getOutputStream();
                        outputStream.write(userJson.getBytes("UTF-8"));
                        outputStream.flush();
                        filterChain.doFilter(servletRequest, servletResponse);
                    }
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
