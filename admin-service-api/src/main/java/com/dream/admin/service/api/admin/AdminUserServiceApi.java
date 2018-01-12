package com.dream.admin.service.api.admin;

import com.dream.bean.admin.AdminUser;
import com.dream.core.wrapper.Wrapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <p>Title:      AdminUserServiceApi. </p>
 * <p>Description 管理员用户Api </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/4 13:19
 */
@RequestMapping(value = "/api/${managerUrlPrefix}/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public interface AdminUserServiceApi {

    /**
     * <p>Title:      查询所有管理员用户. </p>
     * <p>Description </p>
     *
     * @param
     * @author        <a href="liqd163@163.com"/>李清栋</a>
     * @CreateDate    2018/1/4 13:19
     * @return
     */
    @RequestMapping(value = "/queryList")
    Wrapper<List<AdminUser>> queryList();
}
