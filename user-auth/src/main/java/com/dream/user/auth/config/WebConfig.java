package com.dream.user.auth.config;

import com.dream.core.aop.WebRequestAspect;
import com.dream.core.common.Constant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>Title:      WebConfig. </p>
 * <p>Description 配置类 </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/9 10:17
 */
@Configuration
public class WebConfig {

    @Bean
    public WebRequestAspect webRequestAspect(){
        return new WebRequestAspect();
    }

    @Bean
    public Constant constant(){
        return new Constant();
    }
}