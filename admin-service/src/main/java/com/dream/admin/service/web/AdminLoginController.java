package com.dream.admin.service.web;

import com.dream.admin.service.api.admin.AdminLoginServiceApi;
import com.dream.admin.service.service.AdminLoginService;
import com.dream.core.annotation.WebLog;
import com.dream.core.exception.DreamException;
import com.dream.core.wrapper.WrapMapper;
import com.dream.core.wrapper.Wrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


/**
 * <p>Title:      LoginController. </p>
 * <p>Description TODO </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/8 16:21
 */
@RestController
public class AdminLoginController implements AdminLoginServiceApi {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AdminLoginService loginService;

    @WebLog
    @Override
    public Wrapper<String> login(String loginName, String loginPwd) {
        try {
            String token = loginService.login(loginName, loginPwd);
            return WrapMapper.success(token);
        } catch (DreamException e) {
            logger.error("-->login 登录出现异常", e.getMessage(), e);
            return WrapMapper.error(e.getMessage());
        } catch (Exception e) {
            logger.error("-->login 登录出现异常", e.getMessage(), e);
            return WrapMapper.error();
        }
    }
}
