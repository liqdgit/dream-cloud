package com.dream.admin.web.listener;

import com.dream.core.common.web.DreamSpringApplicationListener;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;


/**
 * <p>Title:      DreamAdminWebListener. </p>
 * <p>Description spring应用监听器 </p>
 *
 * @author <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate 2018/1/12 10:51
 */
public class DreamAdminWebListener extends DreamSpringApplicationListener {

    private static final String packageName = "com.dream.admin.web.controller";

    @Override
    public void handle(ApplicationEvent event) {
        if (event instanceof ApplicationReadyEvent) {
        }

    }

    @Override
    public String getPkgName() {
        return packageName;
    }
}
