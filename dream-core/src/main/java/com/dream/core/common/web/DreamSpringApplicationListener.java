package com.dream.core.common.web;

import com.dream.bean.admin.ApiManager;
import com.dream.core.common.LoadApiData;
import com.dream.core.common.zookeeper.DreamZookeeperNode;
import com.dream.core.common.zookeeper.ZooKeeperNodeOperation;
import com.dream.core.common.zookeeper.ZookeeperClientFactory;
import com.dream.core.config.Constant;
import com.dream.core.config.DreamApplicationNameConfigManager;
import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>Title:      DreamSpringApplicationListener. </p>
 * <p>Description spring 应用监听器 </p>
 *
 * @author <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate 2018/1/11 18:13
 */
public abstract class DreamSpringApplicationListener implements ApplicationListener {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

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

    /**
     * <p>Title:      获取包名. </p>
     * <p>Description </p>
     *
     * @param
     * @author        <a href="liqd163@163.com"/>李清栋</a>
     * @CreateDate    2018/1/23 14:22
     * @return
     */
    public abstract String getPkgName();

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
            ApplicationContext applicationContext = ((ApplicationReadyEvent)event).getApplicationContext();
            DreamApplicationContext.setApplicationContext(applicationContext);
            handle(event);
            apiInit();
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

    /**
     * <p>Title:      初始化Api. </p>
     * <p>Description </p>
     *
     * @param
     * @author        <a href="liqd163@163.com"/>李清栋</a>
     * @CreateDate    2018/1/23 17:27
     * @return
     */
    private void apiInit(){
        ApplicationContext applicationContext = DreamApplicationContext.getApplicationContext();
        Constant constant = applicationContext.getBean(Constant.class);
        DreamApplicationNameConfigManager appNameManager = applicationContext.getBean(DreamApplicationNameConfigManager.class);

        if(constant.getApiManagerServiceNames() != null){
            if(constant.getApiManagerServiceNames().contains(appNameManager.getApplicationName())){
                RequestMappingHandlerMapping requestMappingHandlerMapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
                Map<RequestMappingInfo, HandlerMethod> mappingLookup = requestMappingHandlerMapping.getHandlerMethods();
                List<Method> methodList = LoadApiData.getApi(getPkgName());
                ArrayList<ApiManager> apiManagerList = LoadApiData.format(methodList, mappingLookup);

                DreamZookeeperNode apiManagerNode = new DreamZookeeperNode(appNameManager.getApplicationName(),
                        DreamZookeeperNode.NodePrefix.API_MANAGER.getNodePrefix());
                ZookeeperClientFactory clientFactory = new ZookeeperClientFactory(constant.getZookeeperUrl(), "");
                CuratorFramework client = clientFactory.getClient();
                ZooKeeperNodeOperation nodeOperation = new ZooKeeperNodeOperation(client);

                String apiNode = apiManagerNode.toString();
                try {
                    Stat apiStat = nodeOperation.checkExists(apiNode);
                    if(apiStat != null){
                        nodeOperation.update(apiNode, apiManagerList);
                    }else{
                        nodeOperation.create(apiNode, CreateMode.PERSISTENT, apiManagerList);
                    }
                } catch (Exception e) {
                    logger.error("初始化异常", e);
                } finally {
                    client.close();
                }
            }
        }
    }

}
