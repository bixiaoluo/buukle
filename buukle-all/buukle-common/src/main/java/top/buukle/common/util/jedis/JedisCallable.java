package top.buukle.common.util.jedis;

import top.buukle.common.util.common.SpringContextUtil;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/21.
 * @Description :
 */
abstract class JedisCallable <T> {

    /** springBoot redis 操作api 实例*/
    static StringRedisTemplate stringRedisTemplate = SpringContextUtil.getBean(StringRedisTemplate.class);

    abstract T call();
}
