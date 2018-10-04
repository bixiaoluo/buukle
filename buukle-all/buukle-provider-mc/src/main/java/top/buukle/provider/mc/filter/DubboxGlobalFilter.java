package top.buukle.provider.mc.filter;



import com.alibaba.dubbo.rpc.*;
import top.buukle.common.request.BaseRequest;
import top.buukle.common.constants.BaseResponseCode;
import top.buukle.common.exception.BaseException;
import top.buukle.provider.mc.util.RequestValidation;


/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/23.
 * @Description :
 */
public class DubboxGlobalFilter implements Filter{


    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
//        LOGGER.info("请求参数为{}", buffer.toString());
//        LOGGER.info("请求参数Map为{}", reqMap);
//        LOGGER.info("请求头部Map为{}", headerMap);
        Object[] arguments = invocation.getArguments();
        BaseRequest baseRequest = (BaseRequest) arguments[0];
        if(!RequestValidation.validate(baseRequest)){
            throw new BaseException(BaseResponseCode.BASE_REQUEST_NULL);
        }
        return invoker.invoke(invocation);
    }
}
