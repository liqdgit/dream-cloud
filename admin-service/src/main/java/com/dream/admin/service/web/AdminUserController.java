package com.dream.admin.service.web;

import com.dream.admin.service.api.admin.AdminUserServiceApi;
import com.dream.admin.service.service.AdminUserService;
import com.dream.bean.admin.AdminUser;
import com.dream.core.annotation.WebLog;
import com.dream.core.wrapper.WrapMapper;
import com.dream.core.wrapper.Wrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 * <p>Title:      AdminUserController. </p>
 * <p>Description TODO </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/4 16:10
 */
@RestController
public class AdminUserController implements AdminUserServiceApi {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AdminUserService adminUserService;

    @WebLog
    @Override
    public Wrapper<List<AdminUser>> queryList() {
        try {
            List<AdminUser> list = adminUserService.queryList();
            return WrapMapper.success(list);
        } catch (Exception e) {
            logger.error("--queryList:查询所有管理员用户异常", e);
            return WrapMapper.error();
        }
    }
}
