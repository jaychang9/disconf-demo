package cn.jaychang.disconf.config;

import cn.jaychang.disconf.component.RedisComponent;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Comments：
 * Author：Jay Chang
 * Create Date：2017/10/20
 * Modified By：
 * Modified Date：
 * Why & What is modified：
 * Version：v1.0
 */
public class RedisConfigTest {

    @Test
    public void getPort() throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("cn.jaychang.disconf.config","cn.jaychang.disconf.component");
        context.refresh();
        RedisConfig redisConfig = context.getBean(RedisConfig.class);
        System.out.println(redisConfig.getHost()+":"+redisConfig.getPort());

        RedisComponent redisComponent = context.getBean(RedisComponent.class);
        System.out.println(redisComponent.get("key"));

        System.in.read();
    }

    @Test
    public void getHost() throws Exception {

    }

}