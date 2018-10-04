package top.buukle.api.out.sso.vo.query;

import top.buukle.api.out.sso.entity.User;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/30.
 * @Description : 用户授权vo
 */
public class UserLoginPermissionQuery  implements java.io.Serializable{

    private String userCookie;
    private String url;
    private User user;

    public String getuserCookie() {
        return userCookie;
    }

    public void setuserCookie(String userCookie) {
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
