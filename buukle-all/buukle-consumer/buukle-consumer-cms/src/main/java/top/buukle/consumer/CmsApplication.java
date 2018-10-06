package top.buukle.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(scanBasePackages={"top.buukle.common","top.buukle.consumer.cms","top.buukle.plugin.security"})
@ImportResource(locations = {"classpath:config/spring/springBootContext.xml"})
@EnableFeignClients(basePackages = {"top.buukle.plugin.security.invoker","top.buukle.consumer.cms.invoker"})
public class CmsApplication {
    private static volatile boolean RUNNING = true;
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(CmsApplication.class, args);
        System.out.println("启动成功");
        synchronized (CmsApplication.class) {
            while (RUNNING) {
                try {
                    CmsApplication.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    SpringApplication.exit(context);
                }
            }
        }
    }
}
