package com.dream.admin.web.config;

import com.dream.core.aop.WebRequestAspect;
import com.dream.core.common.Constant;
import com.dream.core.common.DreamApplicationNameConfigManager;
import com.dream.core.common.DreamIPConfigManager;
import com.dream.core.common.DreamPortConfigManager;
import com.dream.core.web.DreamServletContextListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletContextEvent;

/**
 * <p>Title:      WebConfig. </p>
 * <p>Description 配置类 </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/5 13:35
 */
@Configuration
public class WebConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public WebRequestAspect webRequestAspect(){
        return new WebRequestAspect();
    }

    @Bean
    public DreamServletContextListener dreamServletContextListener(){
        DreamServletContextListener listener = new DreamServletContextListener() {

            private final Logger logger = LoggerFactory.getLogger(this.getClass());

            @Override
            public void init(ServletContextEvent servletContextEvent) {
            }

            @Override
            public void destroyed(ServletContextEvent servletContextEvent) {
                logger.info("--> 服务器已销毁");
            }

        };
        return listener;
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
    public DreamIPConfigManager dreamIPConfigManager(){
        return new DreamIPConfigManager();
    }

    @Bean
    public DreamPortConfigManager dreamPortConfigManager(){
        return new DreamPortConfigManager();
    }

}
