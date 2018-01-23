package com.dream.core.common.zookeeper;

/**
 * <p>Title:      DreamZookeeperNode. </p>
 * <p>Description zookeeper节点 </p>
 *
 * @author <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate 2018/1/23 13:25
 */
public class DreamZookeeperNode {


    public static class RequestMappingNode {

        public static final String prefix = "/requestMapping";
        private String serviceName;

        public RequestMappingNode(String serviceName){
            this.serviceName = "/" + serviceName;
        }

        public String getServiceName() {
            return serviceName;
        }

        public void setServiceName(String serviceName) {
            this.serviceName = serviceName;
        }

        @Override
        public String toString() {
            return prefix + serviceName;
        }
    }

    public static class ApiManagerNode {

        public static final String prefix = "/apiManager";
        private String serviceName;

        public ApiManagerNode(String serviceName){
            this.serviceName = "/" + serviceName;
        }

        public String getServiceName() {
            return serviceName;
        }

        public void setServiceName(String serviceName) {
            this.serviceName = serviceName;
        }

        @Override
        public String toString() {
            return prefix + serviceName;
        }
    }
}
