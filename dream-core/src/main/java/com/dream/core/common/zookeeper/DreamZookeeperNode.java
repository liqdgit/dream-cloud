package com.dream.core.common.zookeeper;

/**
 * <p>Title:      DreamZookeeperNode. </p>
 * <p>Description zookeeper节点 </p>
 *
 * @author <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate 2018/1/23 13:25
 */
public class DreamZookeeperNode {

    public String prefix;
    private String serviceName;

    public DreamZookeeperNode(String serviceName, String prefix){
        this.serviceName = "/" + serviceName;
        this.prefix = prefix;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String toString() {
        return prefix + serviceName;
    }


    public enum NodePrefix {
        REQUEST_MAPPING("/requestMapping", "requestMapping"),
        API_MANAGER("/apiManager", "Api信息");

        private String nodePrefix;

        private String desc;

        NodePrefix(String nodePrefix, String desc){
            this.nodePrefix = nodePrefix;
            this.desc = desc;
        }

        public String getNodePrefix() {
            return nodePrefix;
        }

        public void setNodePrefix(String nodePrefix) {
            this.nodePrefix = nodePrefix;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

    }
}
