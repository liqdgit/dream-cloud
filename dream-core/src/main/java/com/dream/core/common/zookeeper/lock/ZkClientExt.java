package com.dream.core.common.zookeeper.lock;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.ZkSerializer;
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.Callable;

/**
 * Created by edz on 2018/2/27.
 */
public class ZkClientExt extends ZkClient {

    public ZkClientExt(String serverstring) {
        super(serverstring);
    }

    public ZkClientExt(String zkServers, int sessionTimeout, int connectionTimeout, ZkSerializer zkSerializer) {
        super(zkServers, sessionTimeout, connectionTimeout, zkSerializer);
    }

    @Override
    public void watchForData(final String path) {
        retryUntilConnected(new Callable<Object>() {

            @Override
            public Object call() throws Exception {
                Stat stat = new Stat();
                _connection.readData(path, stat, true);
                return null;
            }

        });
    }
}
