package top.buukle.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(scanBasePackages={"top.buukle.common","top.buukle.provider.mc"})
@ImportResource(locations = {"classpath:config/spring/springBootContext.xml"})
@MapperScan("top.buukle.provider.mc.dao.*")
@EnableEurekaClient
public class McApplication {

    /** 应用逻辑开关监听*/
    private static volatile boolean RUNNING = true;
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(McApplication.class, args);
        System.out.println("启动成功");
        synchronized (McApplication.class) {
            while (RUNNING) {
                try {
                    McApplication.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    SpringApplication.exit(context);
                }
            }
        }
    }
}
