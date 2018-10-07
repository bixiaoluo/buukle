package top.buukle.provider;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@SpringBootApplication(scanBasePackages={"top.buukle.common", "top.buukle.provider.security", "top.buukle.plugin.security"})
@EnableFeignClients(basePackages = {"top.buukle.plugin.security.invoker"})
public class SecurityApplication {
    /** 应用逻辑开关监听*/
    private static volatile boolean RUNNING = true;
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SecurityApplication.class, args);
        System.out.println("启动成功");
        synchronized (SecurityApplication.class) {
            while (RUNNING) {
                try {
                    SecurityApplication.class.wait();
                } catch (InterruptedException e) {
                } finally {
                    SpringApplication.exit(context);
                }
            }
        }
    }

}
