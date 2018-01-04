package com.dream.admin.web.fallback;

import com.dream.admin.web.service.AdminUserService;
import com.dream.bean.admin.AdminUser;
import com.dream.core.common.wrapper.WrapMapper;
import com.dream.core.common.wrapper.Wrapper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
/**
 * <p>Title:      AdminUserFallback. </p>
 * <p>Description TODO </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/4 14:16
 */
@Component
@RequestMapping("/fallback/asdf")
public class AdminUserFallback implements AdminUserService {

    @Override
    public Wrapper<List<AdminUser>> queryList() {
        return WrapMapper.error();
    }
}
