package com.dream.admin.service.api.admin;

import com.dream.bean.admin.ApiManager;
import com.dream.core.common.wrapper.Wrapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>Title:      ApiManagerServiceApi. </p>
 * <p>Description TODO </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/11 17:21
 */
@RequestMapping(value = "/api/${managerUrlPrefix}/api-manager", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public interface ApiManagerServiceApi {

    /**
     * <p>Title:      . </p>
     * <p>Description </p>
     *
     * @param         list
     * @param         serviceName
     * @author        <a href="liqd163@163.com"/>李清栋</a>
     * @CreateDate    2018/1/11 17:18
     * @return
     */
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    Wrapper insert(@RequestBody List<ApiManager> list, @RequestParam("serviceName") String serviceName);

    /**
     * <p>Title:      根据方法名查询. </p>
     * <p>Description </p>
     *
     * @param         methodName
     * @author        <a href="liqd163@163.com"/>李清栋</a>
     * @CreateDate    2018/1/12 17:28
     * @return
     */
    @RequestMapping(value = "queryByMethodName", method = RequestMethod.POST)
    Wrapper<ApiManager> queryByMethodName(@RequestParam("methodName") String methodName);
}
