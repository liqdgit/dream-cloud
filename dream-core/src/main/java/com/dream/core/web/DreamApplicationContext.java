package com.dream.core.web;


import org.springframework.context.ApplicationContext;

/**
 * <p>Title:      DreamApplicationContext. </p>
 * <p>Description TODO </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/8 10:43
 */
public final class DreamApplicationContext {

    private DreamApplicationContext(){
    }

    private static ApplicationContext applicationContext = null;

    public static ApplicationContext setApplicationContext(ApplicationContext app){
        applicationContext = app;
        return applicationContext;
    }

    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }
}
