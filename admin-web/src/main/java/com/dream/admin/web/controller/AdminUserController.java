package com.dream.admin.web.controller;

import com.dream.admin.web.service.AdminUserService;
import com.dream.bean.admin.AdminUser;
import com.dream.core.common.annotation.DreamRequest;
import com.dream.core.common.base.BaseController;
import com.dream.core.common.wrapper.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>Title:      AdminUserController. </p>
 * <p>Description TODO </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/4 13:53
 */
@RestController
@RequestMapping(value = "${managerUrlPrefix}/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AdminUserController extends BaseController {

    @Autowired
    private AdminUserService adminUserService;

    @DreamRequest
    @RequestMapping("queryList")
    public Wrapper<List<AdminUser>> queryList(AdminUser adminUser){
        Wrapper<List<AdminUser>> wrapper = adminUserService.queryList();
        return wrapper;
    }
}
