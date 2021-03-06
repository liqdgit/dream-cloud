package com.dream.core.common.base;

/**
 * <p>Title:      DreamMapper. </p>
 * <p>Description Mybatis 通用Mapper基类 </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/4 11:10
 */
public interface DreamMapper<T> {

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
