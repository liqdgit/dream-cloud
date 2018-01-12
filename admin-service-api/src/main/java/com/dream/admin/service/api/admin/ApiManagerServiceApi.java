package com.dream.admin.service.api.admin;

import com.dream.bean.admin.ApiManager;
import com.dream.core.wrapper.Wrapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

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
     * @author        <a href="liqd163@163.com"/>李清栋</a>
     * @CreateDate    2018/1/11 17:18
     * @return
     */
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    Wrapper insert(@RequestBody ArrayList<ApiManager> list);
}
