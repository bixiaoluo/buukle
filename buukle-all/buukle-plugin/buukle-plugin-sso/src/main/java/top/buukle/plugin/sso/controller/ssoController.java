package top.buukle.plugin.sso.controller;

import top.buukle.plugin.sso.constants.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/2.
 * @Description :
 */
@Controller
public class ssoController {

    /**
     * 去往登陆页面
     * @param modelAndView
     * @return
     */
    @RequestMapping("${"+ Constants.LOGIN_PATH_ENVIRONMENT_KEY+"}")
    public  ModelAndView login(ModelAndView modelAndView) {
        modelAndView.setViewName(Constants.VIEW_NAME_PARAMETERS.getLoginViewName());
        return modelAndView;
    }
    /**
     * 去往首页页面
     * @param modelAndView
     * @return
     */
    @RequestMapping("${"+ Constants.INDEX_PATH_ENVIRONMENT_KEY+"}")
    public  ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName(Constants.VIEW_NAME_PARAMETERS.getIndexViewName());
        return modelAndView;
    }
    /**
     * 去往超时页面
     * @param modelAndView
     * @return
     */
    @RequestMapping("${"+ Constants.OUT_OF_TIME_PATH_LOGIN_PATH_ENVIRONMENT_KEY+"}")
    public  ModelAndView outOfTime(ModelAndView modelAndView) {
        modelAndView.setViewName(Constants.VIEW_NAME_PARAMETERS.getOutOfTimeViewName());
        return modelAndView;
    }
    /**
     * 去往越权页面
     * @param modelAndView
     * @return
     */
    @RequestMapping("${"+ Constants.NO_PERMISSION_PATH_ENVIRONMENT_KEY+"}")
    public  ModelAndView noPermission(ModelAndView modelAndView) {
        modelAndView.setViewName(Constants.VIEW_NAME_PARAMETERS.getNoPermissionViewName());
        return modelAndView;
    }
    /**
     * 去往错误页面
     * @param modelAndView
     * @return
     */
    @RequestMapping("${"+ Constants.ERROR_PAGE_PATH_ENVIRONMENT_KEY+"}")
    public  ModelAndView error(ModelAndView modelAndView) {
        modelAndView.setViewName(Constants.VIEW_NAME_PARAMETERS.getErrorViewName());
        return modelAndView;
    }
    /**
     * 去往登出页面
     * @param modelAndView
     * @return
     */
    @RequestMapping("${"+ Constants.LOGOUT_PATH_ENVIRONMENT_KEY+"}")
    public  ModelAndView logout(ModelAndView modelAndView) {
        modelAndView.setViewName(Constants.VIEW_NAME_PARAMETERS.getLogoutViewName());
        return modelAndView;
    }
}