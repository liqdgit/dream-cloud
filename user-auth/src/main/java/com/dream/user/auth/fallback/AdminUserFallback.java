package com.dream.user.auth.fallback;

import com.dream.bean.admin.AdminUser;
import com.dream.core.wrapper.WrapMapper;
import com.dream.core.wrapper.Wrapper;
import com.dream.user.auth.service.AdminUserService;
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
@RequestMapping("/fallback")
public class AdminUserFallback implements AdminUserService {

    @Override
    public Wrapper<List<AdminUser>> queryList() {
        return WrapMapper.error();
    }
}
