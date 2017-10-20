package cn.jaychang.disconf.component;

import cn.jaychang.disconf.config.RedisConfig;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Comments：
 * Author：Jay Chang
 * Create Date：2017/10/20
 * Modified By：
 * Modified Date：
 * Why & What is modified：
 * Version：v1.0
 */
@Component
public class RedisComponent implements InitializingBean,DisposableBean {
    @Autowired
    private RedisConfig redisConfig;


    private JedisPool jedisPool;

    @Override
    public void afterPropertiesSet() throws Exception {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(10);
        jedisPoolConfig.setMaxTotal(15);
        jedisPool = new JedisPool(jedisPoolConfig,redisConfig.getHost(),redisConfig.getPort());
    }

    public String get(String key){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.get(key);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            if(null != jedis){
                jedis.close();
            }
        }
    }

    @Override
    public void destroy() throws Exception {
        jedisPool.destroy();
    }
}
