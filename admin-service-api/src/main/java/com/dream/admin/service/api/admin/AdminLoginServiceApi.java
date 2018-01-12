package com.dream.admin.service.api.admin;


import com.dream.core.wrapper.Wrapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>Title:      AdminLoginServiceApi. </p>
 * <p>Description 登录 </p>
 *
 * @author <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate 2018/1/8 16:19
 */
@RequestMapping(value = "/api/${managerUrlPrefix}/login", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public interface AdminLoginServiceApi {

    /**
     * <p>Title:      登录. </p>
     * <p>Description </p>
     *
     * @param loginName
     * @param loginPwd
     * @return
     * @author <a href="liqd163@163.com"/>李清栋</a>
     * @CreateDate 2018/1/8 16:20
     */
    @RequestMapping("/login")
    Wrapper<String> login(@RequestParam("loginName") String loginName, @RequestParam("loginPwd") String loginPwd);
}
