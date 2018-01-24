package com.dream.core.common.zookeeper;

import com.dream.bean.admin.ApiManager;
import com.dream.core.common.util.ObjectSerializeUtil;
import com.dream.core.common.web.DreamApplicationContext;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * <p>Title:      ZookeeperNodeListener. </p>
 * <p>Description 节点监听类 </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/23 17:48
 */
public abstract class ZookeeperNodeListener implements PathChildrenCacheListener {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void childEvent(CuratorFramework curatorFramework, PathChildrenCacheEvent event) throws Exception {
        logger.info("zookeeper节点{}，监听类型{}", event.getData().getPath(), event.getType().toString());
        if(event.getType() == PathChildrenCacheEvent.Type.CHILD_ADDED
                || event.getType() == PathChildrenCacheEvent.Type.CHILD_UPDATED){
            byte[] bytes = event.getData().getData();
            if(bytes != null && bytes.length > 0){
                logger.info("读取zookeeper节点数据，初始化Api接口...");
                List<ApiManager> list = ObjectSerializeUtil.deserialize(bytes);
                String[] paths = event.getData().getPath().split("/");
                handleApi(list, paths[paths.length - 1]);
            }
        }
    }

    /**
     * <p>Title:      处理Api数据. </p>
     * <p>Description </p>
     *
     * @param         list
     * @param         serviceName
     * @author        <a href="liqd163@163.com"/>李清栋</a>
     * @CreateDate    2018/1/23 18:17
     * @return
     */
    public abstract void handleApi(List<ApiManager> list, String serviceName);
}
