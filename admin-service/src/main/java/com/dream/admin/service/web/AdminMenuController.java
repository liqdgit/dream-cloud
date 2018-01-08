package com.dream.admin.service.web;

import com.dream.admin.service.api.admin.AdminMenuServiceApi;
import com.dream.admin.service.service.AdminMenuService;
import com.dream.bean.admin.AdminMenu;
import com.dream.core.annotation.WebLog;
import com.dream.core.common.Page;
import com.dream.core.wrapper.WrapMapper;
import com.dream.core.wrapper.Wrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>Title:      AdminMenuController. </p>
 * <p>Description TODO </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/8 11:17
 */
@RestController
public class AdminMenuController implements AdminMenuServiceApi {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AdminMenuService adminMenuService;

    @WebLog
    @Override
    public Wrapper<PageInfo<AdminMenu>> queryPageList(Page<AdminMenu> page) {
        try {
            PageHelper.startPage(page.getPageNum(), page.getPageSize());
            List<AdminMenu> list = adminMenuService.queryPageList(page.getData());
            PageInfo<AdminMenu> pageInfo = new PageInfo<>(list);
            return WrapMapper.success(pageInfo);
        } catch (Exception e) {
            logger.error("--> queryPageList:菜单分页查询异常", e.getMessage(), e);
            return WrapMapper.error();
        }
    }
}
