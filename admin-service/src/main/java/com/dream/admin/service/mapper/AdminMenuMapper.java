package com.dream.admin.service.mapper;

import com.dream.bean.admin.AdminMenu;
import com.dream.core.common.base.DreamMapper;

import java.util.List;

/**
 * <p>Title:      AdminMenuMapper. </p>
 * <p>Description 菜单 </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/5 11:19
 */
public interface AdminMenuMapper extends DreamMapper<AdminMenu> {

    /**
     * <p>Title:      分页查询. </p>
     * <p>Description </p>
     *
     * @param         adminMenu
     * @author        <a href="liqd163@163.com"/>李清栋</a>
     * @CreateDate    2018/1/8 11:13
     * @return
     */
    List<AdminMenu> queryPageList(AdminMenu adminMenu);
}