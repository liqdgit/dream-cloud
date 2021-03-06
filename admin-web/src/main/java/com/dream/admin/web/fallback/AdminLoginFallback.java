package com.dream.admin.web.fallback;

import com.dream.admin.web.service.AdminLoginService;
import com.dream.core.common.wrapper.WrapMapper;
import com.dream.core.common.wrapper.Wrapper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>Title:      AdminLoginFallback. </p>
 * <p>Description TODO </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/8 16:29
 */
@Component
@RequestMapping("/fallback")
public class AdminLoginFallback implements AdminLoginService {

    @Override
    public Wrapper<String> login(String loginName, String loginPwd) {
        return WrapMapper.error("登录失败");
    }
}
