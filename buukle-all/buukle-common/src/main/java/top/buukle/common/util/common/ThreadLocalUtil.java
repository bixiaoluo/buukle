package top.buukle.common.util.common;

import top.buukle.common.vo.ThreadParam;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/3.
 * @Description : user 实体线程本地变量工具类
 */
public class ThreadLocalUtil {

    private  static ThreadLocal<ThreadParam> THREAD_LOCAL_USER_INFO = new ThreadLocal();

    public static void set(ThreadParam param) {
        THREAD_LOCAL_USER_INFO.set(param);
    }

    public static ThreadParam get() {
        return THREAD_LOCAL_USER_INFO.get();
    }
}
