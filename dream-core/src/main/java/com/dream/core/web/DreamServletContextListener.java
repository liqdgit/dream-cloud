package com.dream.core.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * <p>Title:      DreamServletContextListener. </p>
 * <p>Description 监听器 </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/8 10:51
 */
public abstract class DreamServletContextListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        init(servletContext);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    /**
     * <p>Title:      ServletContext 初始化. </p>
     * <p>Description </p>
     *
     * @param         servletContext
     * @author        <a href="liqd163@163.com"/>李清栋</a>
     * @CreateDate    2018/1/8 10:53
     * @return
     */
    public abstract void init(ServletContext servletContext);
}
