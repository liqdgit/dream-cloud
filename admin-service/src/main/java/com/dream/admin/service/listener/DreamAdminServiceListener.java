package com.dream.admin.service.listener;

import com.dream.admin.service.service.ApiManagerService;
import com.dream.bean.admin.ApiManager;
import com.dream.core.common.web.DreamApplicationContext;
import com.dream.core.common.web.DreamSpringApplicationListener;
import com.dream.core.common.zookeeper.DreamZookeeperNode;
import com.dream.core.common.zookeeper.ZooKeeperNodeOperation;
import com.dream.core.common.zookeeper.ZookeeperClientFactory;
import com.dream.core.common.zookeeper.ZookeeperNodeListener;
import com.dream.core.config.Constant;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;

import java.util.List;

/**
 * <p>Title:      DreamAdminWebListener. </p>
 * <p>Description spring应用监听器 </p>
 *
 * @author <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate 2018/1/12 10:51
 */
public class DreamAdminServiceListener extends DreamSpringApplicationListener {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void handle(ApplicationEvent event) {
        if (event instanceof ApplicationReadyEvent) {
            ApplicationContext applicationContext = DreamApplicationContext.getApplicationContext();
            Constant constant = applicationContext.getBean(Constant.class);
            List<String> serviceNames = constant.getApiManagerServiceNames();
            DreamZookeeperNode apiManagerNode;
            ZookeeperClientFactory clientFactory = new ZookeeperClientFactory(constant.getZookeeperUrl(), "");
            CuratorFramework client = clientFactory.getClient();
            ZooKeeperNodeOperation nodeOperation = new ZooKeeperNodeOperation(client);
            final ApiManagerService apiManagerService = applicationContext.getBean(ApiManagerService.class);
            if(serviceNames != null){
                for (String str: serviceNames){
                    apiManagerNode = new DreamZookeeperNode(str, DreamZookeeperNode.NodePrefix.API_MANAGER.getNodePrefix());
                    String node = apiManagerNode.toString();
                    try {
                        if(nodeOperation.checkExists(node) != null){
                            List<ApiManager> list = nodeOperation.get(node);
                            apiManagerService.insertInit(list, str);
                        }
                        PathChildrenCache cache = new PathChildrenCache(client, DreamZookeeperNode.NodePrefix.API_MANAGER.getNodePrefix(), true);
                        ZookeeperNodeListener nodeListener = new ZookeeperNodeListener() {
                            @Override
                            public void handleApi(List<ApiManager> list, String serviceName) {
                                try {
                                    apiManagerService.insertInit(list, serviceName);
                                } catch (Exception e) {
                                    logger.error(e.getMessage(), e);
                                }
                            }
                        };
                        cache.getListenable().addListener(nodeListener);
                        cache.start();
                    } catch (Exception e) {
                        logger.error(e.getMessage(), e);
                    }
                }
            }

        }
    }

    @Override
    public String getPkgName() {
        return "";
    }
}
