package com.dream.gateway.config;

import com.dream.core.aop.WebRequestAspect;
import com.dream.core.common.DreamApplicationNameConfigManager;
import com.dream.core.common.DreamIPConfigManager;
import com.dream.core.common.DreamPortConfigManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>Title:      WebConfig. </p>
 * <p>Description web 配置 </p>
 *
 * @author <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate 2018/1/5 16:23
 */
@Configuration
public class WebConfig {

    @Bean
    public WebRequestAspect webRequestAspect() {
        return new WebRequestAspect();
    }

    @Bean
    public DreamApplicationNameConfigManager dreamApplicationNameConfigManager(){
        return new DreamApplicationNameConfigManager();
    }

    @Bean
    public DreamIPConfigManager dreamIPConfigManager(){
        return new DreamIPConfigManager();
    }

    @Bean
    public DreamPortConfigManager dreamPortConfigManager(){
        return new DreamPortConfigManager();
    }
}
