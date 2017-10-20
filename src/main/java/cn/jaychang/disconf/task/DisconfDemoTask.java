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
public class DisconfDemoTask {

    protected static final Logger LOGGER = LoggerFactory
        .getLogger(DisconfDemoTask.class);

    @Autowired
    private RedisComponent simpleRedisService;

    @Autowired
    private RedisConfig redisConfig;

    private static final String REDIS_KEY = "disconf_key";

    /**
     *
     */
    public int run() {

        try {

            while (true) {

                Thread.sleep(5000);

                LOGGER.info("redis( " + redisConfig.getHost() + ","
                    + redisConfig.getPort() + ")  get key: " + REDIS_KEY);

            }

        } catch (Exception e) {

            LOGGER.error(e.toString(), e);
        }

        return 0;
    }
}
