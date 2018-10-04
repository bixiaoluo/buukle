package top.buukle.provider.mc.controller;

import top.buukle.api.inner.mc.UserService;
import top.buukle.daoEntity.mc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/19.
 * @Description :
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/getUserById/{id}")
    @ResponseBody
    public User getUserById(@PathVariable("id") Integer id) throws Exception {
        return  userService.getUserById(id);
    }
}
