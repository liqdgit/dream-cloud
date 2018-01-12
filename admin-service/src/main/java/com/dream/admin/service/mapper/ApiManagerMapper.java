package com.dream.admin.service.mapper;


import com.dream.bean.admin.ApiManager;
import com.dream.core.base.DreamMapper;
/**
 * <p>Title:      ApiManagerMapper. </p>
 * <p>Description api管理 </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/11 16:52
 */
public interface ApiManagerMapper extends DreamMapper<ApiManager> {

    /**
     * <p>Title:      更新状态. </p>
     * <p>Description </p>
     *
     * @param         apiManager
     * @author        <a href="liqd163@163.com"/>李清栋</a>
     * @CreateDate    2018/1/12 17:26
     * @return
     */
    int updateStatus(ApiManager apiManager);

    /**
     * <p>Title:      根据方法名查询. </p>
     * <p>Description </p>
     *
     * @param         methodName
     * @author        <a href="liqd163@163.com"/>李清栋</a>
     * @CreateDate    2018/1/12 17:28
     * @return
     */
    ApiManager queryByMethodName(String methodName);
}