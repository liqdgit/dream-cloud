package com.dream.admin.web.controller;

import com.dream.admin.web.service.ApiManagerService;
import com.dream.core.common.base.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;


/**
 * <p>Title:      ApiManagerController. </p>
 * <p>Description api 管理 </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/12 16:48
 */
@RestController
@RequestMapping(value = "${managerUrlPrefix}/api/manager", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ApiManagerController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ApiManagerService apiManagerService;
    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;
    @Value("${spring.application.name}")
    private String serviceName;


}
