package com.dream.admin.web.controller;

import com.dream.admin.web.service.AdminMenuService;
import com.dream.bean.admin.AdminMenu;
import com.dream.core.common.annotation.DreamRequest;
import com.dream.core.common.base.BaseController;
import com.dream.core.common.Page;
import com.dream.core.common.wrapper.Wrapper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Title:      AdminMenuController. </p>
 * <p>Description TODO </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/8 13:29
 */
@RestController
@RequestMapping(value = "${managerUrlPrefix}/menu", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AdminMenuController extends BaseController {

    @Autowired
    private AdminMenuService adminMenuService;

    @RequestMapping(value = "index")
    public String index(){
        return "menu/index";
    }

    @DreamRequest
    @RequestMapping(value = "queryPageList")
    public Wrapper<PageInfo<AdminMenu>> queryPageList(Page<AdminMenu> page){
        Wrapper<PageInfo<AdminMenu>> wrapper = adminMenuService.queryPageList(page);
        return wrapper;
    }
}
