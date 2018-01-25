package com.dream.admin.service.service;

import com.dream.admin.service.mapper.AdminUserMapper;
import com.dream.bean.admin.AdminUser;
import com.dream.core.common.base.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * <p>Title:      AdminUserService. </p>
 * <p>Description TODO </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/4 15:56
 */
@Service
public class AdminUserService extends BaseService<AdminUserMapper, AdminUser> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public List<AdminUser> queryList(){
        logger.info("-->queryList：查询全部用户信息");
        return mapper.queryList();
    }

    /**
     * <p>Title:      根据登录名密码查询. </p>
     * <p>Description </p>
     *
     * @param         adminUser
     * @author        <a href="liqd163@163.com"/>李清栋</a>
     * @CreateDate    2018/1/8 15:55
     * @return
     */
    public AdminUser queryByLoginNameAndPwd(AdminUser adminUser){
        return mapper.queryByLoginNameAndPwd(adminUser);
    }
}
