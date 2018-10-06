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
    /** 用户自定义参数*/
    private String parameter;

    public String getCookie() {
        return cookie;
    }

    public String getParameter() {
        return parameter;
    }

    public String getDefaultMaxAge() {
        return defaultMaxAge;
    }

    public Integer getLoginStrategy() {
        return loginStrategy;
    }

    private ThreadParam(){}

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
        public Biulder setParameter(String parameter) {
            param.parameter = parameter;
            return this;
        }

        public ThreadParam build() {
            return param;
        }
    }
}
