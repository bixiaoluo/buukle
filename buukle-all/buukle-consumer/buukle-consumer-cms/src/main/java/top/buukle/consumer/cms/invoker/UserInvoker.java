package top.buukle.consumer.cms.invoker;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import top.buukle.common.request.BaseRequest;
import top.buukle.common.response.BaseResponse;
import top.buukle.provider.security.entity.User;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/20.
 * @Description :
 */
@FeignClient(value = "buukle-security")
public interface UserInvoker {

    /**
     *
     * @param request
     * @return
     */
    @PostMapping(value = "/api/security/user/doLogin")
    BaseResponse doLogin(BaseRequest request);

    /**
     * @return
     */
    @GetMapping(value = "/api/security/user/getUserById/1")
    User getUserById();
}
