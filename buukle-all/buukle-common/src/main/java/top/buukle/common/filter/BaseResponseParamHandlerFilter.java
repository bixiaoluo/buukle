package top.buukle.common.filter;

import top.buukle.common.util.logger.BaseLogger;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/6.
 * @Description :
 */
public class BaseResponseParamHandlerFilter implements Filter{

    private static final BaseLogger LOGGER = BaseLogger.getLogger(BaseResponseParamHandlerFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        BaseResponseWrapper baseResponseWrapper = new BaseResponseWrapper((HttpServletResponse) servletResponse);
        // 包装返回servletResponse为baseResponseWrapper
        // 1. 重写getStream方法,骗过后面的servlet: 当他们调用 baseResponseWrapper.getOutputStream 时候,就会把数据缓存到我们自定义responseWrapper的缓存流中(ByteArrayOutputStream cacheStream);
        filterChain.doFilter(servletRequest,baseResponseWrapper);
        // 2. 在doFilter之后,后面的servlet在调用baseResponseWrapper.hetOutPutStream().write(){ cacheStream.write(b); outputStream.write(b);}方法时,
        //    通过cacheStream.write(b) 向我们的缓存流中缓存了一份返回的数据,这样我们就能获取到返回值的副本并加以处理,最后决定向调用方返回指定副本的数据了.
        //
        //          方案一 :返回加工处理后的参数 : baseResponseWrapper.getResult() 就是缓存流反序列化后的String字符串,我们可以对他进行加工,然后在转成byte[],然后再
        //          调用原生servletResponse.write(baseResponseWrapper.getResult().getBytes()) 将处理后的参数写会调用方,此时,自定义包装response类不再向原生outputstream
        //          写数据,即 : baseResponseWrapper.hetOutPutStream().write(){ cacheStream.write(b);  /*outputStream.write(b)*/ ;} 否则会造成返回错乱;
        //
        //          方案二 :返回加工处理之前参数 : 此时,自定义包装response类应该向原生outputstream 写数据,即 :
        //          baseResponseWrapper.hetOutPutStream().write(){ cacheStream.write(b);  outputStream.write(b)  ;} ,这种情况直接返回就可以了;
        LOGGER.info("返回参数 :{} ",baseResponseWrapper.getResult());
    }

    @Override
    public void destroy() {

    }
}
