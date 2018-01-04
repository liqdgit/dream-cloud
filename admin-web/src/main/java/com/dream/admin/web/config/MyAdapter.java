package com.dream.admin.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * <p>Title:      MyAdapter. </p>
 * <p>Description 默认地址 </p>
 * <p>Company:    liqingdong </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2017/7/5 17:54
 */
@Configuration
public class MyAdapter extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "login");
        super.addViewControllers( registry );
    }
}
