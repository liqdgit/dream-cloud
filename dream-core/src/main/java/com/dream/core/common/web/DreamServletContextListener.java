package com.dream.core.common.web;

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
        init(servletContextEvent);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        destroyed(servletContextEvent);
    }

    /**
     * <p>Title:      ServletContext 初始化. </p>
     * <p>Description </p>
     *
     * @param         servletContextEvent
     * @author        <a href="liqd163@163.com"/>李清栋</a>
     * @CreateDate    2018/1/8 10:53
     * @return
     */
    public abstract void init(ServletContextEvent servletContextEvent);

    /**
     * <p>Title:      应用销毁. </p>
     * <p>Description </p>
     *
     * @param         servletContextEvent
     * @author        <a href="liqd163@163.com"/>李清栋</a>
     * @CreateDate    2018/1/8 15:26
     * @return
     */
    public abstract void destroyed(ServletContextEvent servletContextEvent);
}
