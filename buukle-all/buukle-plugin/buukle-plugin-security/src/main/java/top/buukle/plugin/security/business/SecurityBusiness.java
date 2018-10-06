package top.buukle.plugin.security.business;


import top.buukle.common.response.BaseResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/6/10.
 * @Description :
 */
public interface SecurityBusiness {


    /**
     * 登出
     * @param request
     * @param response
     */
    void logout(HttpServletRequest request, HttpServletResponse response);

    BaseResponse doLogin(HttpServletRequest request, HttpServletResponse response) throws Exception;

    BaseResponse authAndSetPermission(HttpServletRequest request, HttpServletResponse response, String uri, String ssoDefaultAge, String applicationName) throws Exception;
}
