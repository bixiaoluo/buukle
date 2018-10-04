package top.buukle.daoEntity.mc.vo.query;


import top.buukle.daoEntity.mc.entity.User;

import java.io.Serializable;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/30.
 * @Description : 用户授权vo
 */
public class UserLoginPermissionQuery implements Serializable {

    private String userCookie;
    private String url;
    private User user;

    public String getUserCookie() {
        return userCookie;
    }

    public void setUserCookie(String userCookie) {
        this.userCookie = userCookie;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
