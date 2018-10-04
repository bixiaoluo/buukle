package top.buukle.common.vo;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/3.
 * @Description :
 */
public class ThreadParam {

    /** 用户cookie*/
    private String cookie;
    /** 用户来源应用指定默认超时时间*/
    private String defaultMaxAge;
    /** 用户选定的自动登录策略*/
    private Integer loginStrategy;

    public String getCookie() {
        return cookie;
    }

    public String getDefaultMaxAge() {
        return defaultMaxAge;
    }

    public Integer getLoginStrategy() {
        return loginStrategy;
    }

    /** 内部建造类*/
    public static class Biulder{
        ThreadParam param = new ThreadParam();

        public Biulder setCookie(String cookie) {
            param.cookie = cookie;
            return this;
        }

        public Biulder setDefaultMaxAge(String defaultMaxAge) {
            param.defaultMaxAge = defaultMaxAge;
            return this;
        }

        public Biulder setLoginStrategy(Integer loginStrategy) {
            param.loginStrategy = loginStrategy;
            return this;
        }

        public ThreadParam build() {
            return param;
        }
    }
}
