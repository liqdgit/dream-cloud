package com.dream.admin.web.config;

import com.dream.core.aop.WebRequestAspect;
import com.dream.core.web.DreamServletContextListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContext;

/**
 * <p>Title:      WebConfig. </p>
 * <p>Description 配置类 </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/5 13:35
 */
@Configuration
public class WebConfig {

    @Value("${urlPrefix}")
    private String urlPrefix;

    @Bean
    public WebRequestAspect webRequestAspect(){
        return new WebRequestAspect();
    }

    @Bean
    public DreamServletContextListener dreamServletContextListener(){
        DreamServletContextListener listener = new DreamServletContextListener() {
            @Override
            public void init(ServletContext servletContext) {
                servletContext.setAttribute("urlPrefix", urlPrefix);
            }
        };
        return listener;
    }
}
