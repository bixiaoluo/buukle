package top.buukle.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(scanBasePackages={"top.buukle.common","top.buukle.provider.sso"})
@ImportResource(locations = {"classpath:config/spring/springBootContext.xml"})
public class SsoApplication {

    /** 应用逻辑开关监听*/
    private static volatile boolean RUNNING = true;
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SsoApplication.class, args);
        System.out.println("启动成功");
        synchronized (SsoApplication.class) {
            while (RUNNING) {
                try {
                    SsoApplication.class.wait();
                } catch (InterruptedException e) {
                } finally {
                    SpringApplication.exit(context);
                }
            }
        }
    }
}
