package com.dream.admin.web.listener;

import com.dream.core.api.manager.LoadApiData;
import com.dream.core.common.ApiManagerConstant;
import com.dream.core.web.DreamSpringApplicationListener;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;

import java.lang.reflect.Method;
import java.util.List;

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
            List<Method> methodList = LoadApiData.getApi(packageName);
            ApiManagerConstant.getInstance().initApi(methodList);
        }

    }
}
