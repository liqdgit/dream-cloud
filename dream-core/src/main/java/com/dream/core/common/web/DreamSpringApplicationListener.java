package com.dream.core.common.web;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;

/**
 * <p>Title:      DreamSpringApplicationListener. </p>
 * <p>Description spring 应用监听器 </p>
 *
 * @author <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate 2018/1/11 18:13
 */
public abstract class DreamSpringApplicationListener implements ApplicationListener {


    /**
     * <p>Title:      处理. </p>
     * <p>Description </p>
     *
     * @param event
     * @return
     * @author <a href="liqd163@163.com"/>李清栋</a>
     * @CreateDate 2018/1/11 18:11
     */
    public abstract void handle(ApplicationEvent event);

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        // 初始化环境变量
        if (event instanceof ApplicationEnvironmentPreparedEvent) {
            handle(event);
        }
        // 初始化完成
        if (event instanceof ApplicationPreparedEvent) {
            handle(event);
        }
        // 应用刷新
        if (event instanceof ContextRefreshedEvent) {
            handle(event);
        }
        // 应用已启动完成
        if (event instanceof ApplicationReadyEvent) {
            handle(event);
        }
        // 应用启动，需要在代码动态添加监听器才可捕获
        if (event instanceof ContextStartedEvent) {
            handle(event);

        }
        // 应用停止
        if (event instanceof ContextStoppedEvent) {
            handle(event);
        }
        // 应用关闭
        if (event instanceof ContextClosedEvent) {
            handle(event);
        }

    }
}
