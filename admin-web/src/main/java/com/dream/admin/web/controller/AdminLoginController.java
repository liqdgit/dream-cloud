package com.dream.admin.web.controller;


import com.dream.admin.web.service.AdminLoginService;
import com.dream.core.annotation.DreamRequest;
import com.dream.core.base.BaseController;
import com.dream.core.wrapper.Wrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>Title:      AdminLoginController. </p>
 * <p>Description TODO </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/8 18:22
 */
@RestController
@RequestMapping(value = "${managerUrlPrefix}/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AdminLoginController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AdminLoginService adminLoginService;

    @DreamRequest
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public Wrapper login(String loginName, String loginPwd, HttpServletRequest request){
        logger.info("--> 执行登录操作");
        Wrapper<String> wrapper = adminLoginService.login(loginName, loginPwd);
        if(wrapper.is()){

        }
        return wrapper;
    }
}
