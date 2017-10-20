package cn.jaychang.disconf.config;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Comments：
 * Author：Jay Chang
 * Create Date：2017/10/20
 * Modified By：
 * Modified Date：
 * Why & What is modified：
 * Version：v1.0
 */

@Configuration
@Scope("singleton")
//@PropertySource(value = "classpath:redis.properties",ignoreResourceNotFound = true,encoding = "UTF-8")
@DisconfFile(filename = "redis.properties")
public class RedisConfig {
    //@Value("${redis.host}")
    private String host;
    //@Value("${redis.port}")
    private int port;

    @DisconfFileItem(name = "redis.port",associateField = "port")
    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @DisconfFileItem(name = "redis.host",associateField = "host")
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
