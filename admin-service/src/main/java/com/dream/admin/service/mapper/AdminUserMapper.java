package com.dream.admin.service.mapper;

import com.dream.bean.admin.AdminUser;
import com.dream.core.base.DreamMapper;

import java.util.List;

/**
 * <p>Title:      AdminUserMapper. </p>
 * <p>Description 管理员用户Mapper </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/4 11:33
 */
public interface AdminUserMapper extends DreamMapper<AdminUser> {
    
    /**
     * <p>Title:      查询所有用户. </p>
     * <p>Description </p>
     *
     * @param
     * @author        <a href="liqd163@163.com"/>李清栋</a>
     * @CreateDate    2018/1/4 13:15
     * @return
     */
    List<AdminUser> queryList();

    /**
     * <p>Title:      根据登录名密码查询. </p>
     * <p>Description </p>
     *
     * @param         adminUser
     * @author        <a href="liqd163@163.com"/>李清栋</a>
     * @CreateDate    2018/1/8 15:55
     * @return
     */
    AdminUser queryByLoginNameAndPwd(AdminUser adminUser);
}
