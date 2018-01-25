package com.dream.admin.service.service;

import com.dream.admin.service.mapper.AdminMenuMapper;
import com.dream.bean.admin.AdminMenu;
import com.dream.core.common.base.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>Title:      AdminMenuService. </p>
 * <p>Description TODO </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/8 11:16
 */
@Service
public class AdminMenuService extends BaseService<AdminMenuMapper, AdminMenu> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * <p>Title:      分页查询. </p>
     * <p>Description </p>
     *
     * @param         adminMenu
     * @author        <a href="liqd163@163.com"/>李清栋</a>
     * @CreateDate    2018/1/8 11:13
     * @return
     */
    public List<AdminMenu> queryPageList(AdminMenu adminMenu){
        return mapper.queryPageList(adminMenu);
    }


}
