package top.buukle.consumer.cms.test;

import top.buukle.common.util.common.PropertiesUtil;
import org.junit.Test;

import java.util.Properties;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/2.
 * @Description :
 */
public class testPropertiutil {

    @Test
    public void test01() {
        Properties properties = PropertiesUtil.getProperties("/config/properties/system.properties");
        String o = (String) properties.get("cms.applicationName");
        System.out.println(o);
    }
}
