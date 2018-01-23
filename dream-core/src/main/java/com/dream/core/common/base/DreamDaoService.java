package com.dream.core.common.base;

/**
 * <p>Title:      DreamDaoService. </p>
 * <p>Description TODO </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/5 11:38
 */
public interface DreamDaoService<T> {

    /**
     * <p>Title:      添加. </p>
     * <p>Description </p>
     *
     * @param         record
     * @author        <a href="liqd163@163.com"/>李清栋</a>
     * @CreateDate    2018/1/5 11:17
     * @return
     */
    int insert(T record);

    /**
     * <p>Title:      添加不为空的. </p>
     * <p>Description </p>
     *
     * @param         record
     * @author        <a href="liqd163@163.com"/>李清栋</a>
     * @CreateDate    2018/1/5 11:18
     * @return
     */
    int insertSelective(T record);

    /**
     * <p>Title:      根据id 查询. </p>
     * <p>Description </p>
     *
     * @param         id
     * @author        <a href="liqd163@163.com"/>李清栋</a>
     * @CreateDate    2018/1/5 11:18
     * @return
     */
    T queryById(Integer id);

    /**
     * <p>Title:      修改. </p>
     * <p>Description </p>
     *
     * @param         record
     * @author        <a href="liqd163@163.com"/>李清栋</a>
     * @CreateDate    2018/1/5 11:18
     * @return
     */
    int updateByIdSelective(T record);
}
