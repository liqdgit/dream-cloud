package com.dream.core.common.zookeeper;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * <p>Title:      ZookeeperClientFactory. </p>
 * <p>Description zookeeper客户端工厂类 </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/23 11:18
 */
public class ZookeeperClientFactory {

    /**
     * 客户端
     */
    private CuratorFramework client;

    /**
     * 连接地址
     */
    private String connectString = "127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183";

    /**
     * 重连睡眠时间
     */
    private int baseSleepTimeMs = 1000;

    /**
     * 重连最大次数
     */
    private int maxRetries = 3;

    /**
     * 命名空间
     */
    private String namespace = "";

    /**
     * 会话超时时间，单位毫秒，默认60000ms
     */
    private int sessionTimeoutMs = 6000;

    /**
     * 连接创建超时时间
     */
    private int connectionTimeoutMs = 6000;


    public ZookeeperClientFactory(String connectString,
                                  String namespace) {
        this.connectString = connectString;
        this.namespace = namespace;
    }

    public CuratorFramework getClient() {
        this.init();
        return client;
    }

    public String getConnectString() {
        return connectString;
    }

    public void setConnectString(String connectString) {
        this.connectString = connectString;
    }

    public int getBaseSleepTimeMs() {
        return baseSleepTimeMs;
    }

    public void setBaseSleepTimeMs(int baseSleepTimeMs) {
        this.baseSleepTimeMs = baseSleepTimeMs;
    }

    public int getMaxRetries() {
        return maxRetries;
    }

    public void setMaxRetries(int maxRetries) {
        this.maxRetries = maxRetries;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public int getSessionTimeoutMs() {
        return sessionTimeoutMs;
    }

    public void setSessionTimeoutMs(int sessionTimeoutMs) {
        this.sessionTimeoutMs = sessionTimeoutMs;
    }

    public int getConnectionTimeoutMs() {
        return connectionTimeoutMs;
    }

    public void setConnectionTimeoutMs(int connectionTimeoutMs) {
        this.connectionTimeoutMs = connectionTimeoutMs;
    }

    public void init() {
        if (client == null) {
            RetryPolicy retryPolicy = new ExponentialBackoffRetry(baseSleepTimeMs, maxRetries);
            client = CuratorFrameworkFactory.builder()
                    .connectString(connectString)
                    .sessionTimeoutMs(sessionTimeoutMs)
                    .connectionTimeoutMs(connectionTimeoutMs)
                    .retryPolicy(retryPolicy)
                    .namespace(namespace)
                    .build();
            client.start();
        }
    }

    public void close() {
        if (client != null) {
            client.close();
            this.client = null;
        }
    }
}
