package com.dream.admin.service.api.admin;

import com.dream.bean.admin.AdminMenu;
import com.dream.core.common.Page;
import com.dream.core.wrapper.Wrapper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * <p>Title:      AdminMenuServiceApi. </p>
 * <p>Description 后台管理菜单 </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/8 11:20
 */
@RequestMapping("/api/admin/menu")
public interface AdminMenuServiceApi {

    /**
     * <p>Title:      分页查询. </p>
     * <p>Description </p>
     *
     * @param         page
     * @author        <a href="liqd163@163.com"/>李清栋</a>
     * @CreateDate    2018/1/8 11:21
     * @return
     */
    @RequestMapping(value = "/queryPageList")
    Wrapper<PageInfo<AdminMenu>> queryPageList(Page<AdminMenu> page);
}
