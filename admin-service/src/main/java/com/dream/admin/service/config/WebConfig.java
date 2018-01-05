package com.dream.admin.service.config;

import com.dream.core.aop.WebRequestAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
    public WebRequestAspect webRequestAspect(){
        return new WebRequestAspect();
    }
}
