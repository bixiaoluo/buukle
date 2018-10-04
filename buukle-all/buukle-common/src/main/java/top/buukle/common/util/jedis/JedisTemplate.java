package top.buukle.common.util.jedis;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/21.
 * @Description :
 */
public class JedisTemplate<T> {

    public  T excecute(JedisCallable jedisCallable) {
        return (T) jedisCallable.call();
    }
}
