package com.dream.core.common.zookeeper.lock;

import java.util.concurrent.TimeUnit;

/**
 * <p>Title:      DistributedLock. </p>
 * <p>Description 分布式锁 </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/2/27 10:29
 */
public interface DistributedLock {

    /**
     * <p>Title:      获取锁，如果没有得到就等待. </p>
     * <p>Description </p>
     *
     * @param
     * @author        <a href="liqd163@163.com"/>李清栋</a>
     * @CreateDate    2018/2/27 10:30
     * @return
     */
    void acquire() throws Exception;

    /**
     * <p>Title:       获取锁，直到超时. </p>
     * <p>Description </p>
     *
     * @param         time 超时时间
     * @param         unit time参数的单位
     * @author        <a href="liqd163@163.com"/>李清栋</a>
     * @CreateDate    2018/2/27 10:30
     * @return        是否获取到锁
     */
    boolean acquire(long time, TimeUnit unit) throws Exception;

    /**
     * <p>Title:      释放锁. </p>
     * <p>Description </p>
     *
     * @param         
     * @author        <a href="liqd163@163.com"/>李清栋</a>
     * @CreateDate    2018/2/27 10:31
     * @return        
     */
    void release() throws Exception;
}
