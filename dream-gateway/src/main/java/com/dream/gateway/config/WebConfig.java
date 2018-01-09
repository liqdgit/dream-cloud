package com.dream.gateway.config;

import com.dream.core.aop.WebRequestAspect;
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

    /**
     * <p>Title:      日志切面配置. </p>
     * <p>Description </p>
     *
     * @param
     * @author        <a href="liqd163@163.com"/>李清栋</a>
     * @CreateDate    2018/1/9 13:25
     * @return
     */
    @Bean
    public WebRequestAspect webRequestAspect() {
        return new WebRequestAspect();
    }
}
