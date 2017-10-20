package cn.jaychang.disconf.task;

/**
 * Comments：
 * Author：Jay Chang
 * Create Date：2017/10/20
 * Modified By：
 * Modified Date：
 * Why & What is modified：
 * Version：v1.0
 */

import cn.jaychang.disconf.component.RedisComponent;
import cn.jaychang.disconf.config.RedisConfig;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 演示分布式配置文件、分布式配置的更新Demo
 *
 * @author liaoqiqi
 * @version 2014-6-17
 */
@Service
public class DisconfDemoTask extends Thread{

    protected static final Logger LOGGER = LoggerFactory
        .getLogger(DisconfDemoTask.class);

    @Autowired
    private RedisComponent simpleRedisService;

    @Autowired
    private RedisConfig redisConfig;

    private static final String REDIS_KEY = "disconf_key";

    @PostConstruct
    public void init(){
        this.start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(5000);
                //这里有个地方需要说明，修改disconf-web上的配置后，为什么还能获取redis里相应key的值，因为jedisPool的配置并没有更新过
                //但我们能看到redis( 127.0.0.1,6379)  get key: hello disconf!  redis的主机名，端口号如果在disconf-web上修改后，打印的信息就会相应的修改
                LOGGER.info("redis( " + redisConfig.getHost() + ","
                    + redisConfig.getPort() + ")  get key: " + simpleRedisService.get(REDIS_KEY));
            }
        } catch (Exception e) {
            LOGGER.error(e.toString(), e);
        }
    }
}
