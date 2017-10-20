package cn.jaychang.disconf.config;

import com.baidu.disconf.client.DisconfMgrBean;
import com.baidu.disconf.client.DisconfMgrBeanSecond;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

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
public class DisconfConfig {

    @Bean
    public DisconfMgrBean disconfMgrBean(){
        DisconfMgrBean disconfMgrBean = new DisconfMgrBean();
        disconfMgrBean.setScanPackage("cn.jaychang.disconf.component");
        return disconfMgrBean;
    }

}
