/*
package top.buukle.plugin.security.task;

import top.buukle.common.util.CookieUtil;
import top.buukle.plugin.security.constants.Constants;
import top.buukle.security.service.UserServiceSso;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Timer;
import java.util.TimerTask;

*/
/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/2.
 * @Description :
 *//*

@Component(value = "clearOutOfTimeOnlineCacheTask")
public class ClearOutOfTimeOnlineCacheTask {

    private static final Logger logger = LoggerFactory.getLogger(ClearOutOfTimeOnlineCacheTask.class);
    @Autowired
    private UserServiceSso userServiceSso;
    */
/**
     * 执行清理任务
     *//*

    public void execute() throws InterruptedException {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                logger.info("清理离线cookie,重置COOKIE_MAP任务开始执行...");
                long start = System.currentTimeMillis();
                userServiceSso.clearOfflineUserCookie();
                CookieUtil.COOKIE_MAP.clear();
                CookieUtil.COOKIE_MAP.put(CookieUtil.COOKIE_MAP_INITIALIZE_STATUS_KEY,CookieUtil.COOKIE_MAP_INITIALIZE_STATUS_VALUE_TRUE);
                logger.info("清理离线cookie,重置COOKIE_MAP任务执行结束,耗时 : {}",System.currentTimeMillis()-start);
            }
        },
                //延时0秒执行
                0 ,
                //24小时后执行一次
                SecurityConstants.CLEAN_OUT_0F_TIME_USER_COOKIE_DELAY
                //3000
        );
    }
}
*/
