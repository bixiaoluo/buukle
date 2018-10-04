package top.buukle.provider.sso.controller;

import top.buukle.api.out.sso.UserSsoBusiness;
import top.buukle.api.out.sso.entity.User;
import top.buukle.common.request.BaseRequest;
import top.buukle.common.request.RequestHead;
import top.buukle.common.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/21.
 * @Description :
 */
@Controller
@RequestMapping("/ssoRedis")
public class SsoRedisController {

    @Autowired
    private UserSsoBusiness userSsoBusiness;

    @RequestMapping("/addStr/{key}/{value}")
    @ResponseBody
    public boolean addStr(@PathVariable("key") String key ,@PathVariable("value") String value) {
        userSsoBusiness.addStr(key,value);
        return true;
    }

    @RequestMapping("/getStr/{key}")
    @ResponseBody
    public String getStr(@PathVariable("key") String key) {
        return userSsoBusiness.getStr(key);
    }

    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
    @RequestMapping("/getUserById/{id}")
    @ResponseBody
    public BaseResponse getUserById(@PathVariable("id") Integer id) {
        return userSsoBusiness.getUserById(id);
    }

    /**
     * 根据id获取用户信息
     * @return
     */
    @RequestMapping("/getUserById")
    @ResponseBody
    public BaseResponse getUserById() throws Exception {
        BaseRequest request = new BaseRequest();
        RequestHead requestHead = new RequestHead.Builder().setOperationName("张召忠").build("sso");
        request.setInfo(new User(1));
        request.setRequestHead(requestHead);
//        BaseResponse re = userSsoBusiness.getUserById(request);
//        List<User>  data1 =  re.getBusiness().getListData(User.class);
//        Integer id = data1.get(0).getId();
        return userSsoBusiness.getUserById(request);
    }
}
