package com.dream.gateway.config;

import com.dream.core.config.aop.WebRequestAspect;
import com.dream.core.config.Constant;
import com.dream.core.config.DreamApplicationNameConfigManager;
import com.dream.core.config.DreamIpConfigManager;
import com.dream.core.config.DreamPortConfigManager;
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
    public Constant constant(){
        return new Constant();
    }

    @Bean
    public DreamApplicationNameConfigManager dreamApplicationNameConfigManager(){
        return new DreamApplicationNameConfigManager();
    }

    @Bean
    public DreamIpConfigManager dreamIPConfigManager(){
        return new DreamIpConfigManager();
    }

    @Bean
    public DreamPortConfigManager dreamPortConfigManager(){
        return new DreamPortConfigManager();
    }
}
