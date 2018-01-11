package com.dream.admin.web.controller;

import com.dream.core.annotation.WebLog;
import com.dream.core.base.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>Title:      IndexController. </p>
 * <p>Description Index </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/4 17:51
 */
@Controller
@RequestMapping(value = "${managerUrlPrefix}/")
public class IndexController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @WebLog
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(){
        logger.info("-->index:进入index页");
        return "/index";
    }

    @WebLog
    @RequestMapping(value = "/index/main", method = RequestMethod.GET)
    public String indexMain(){
        logger.info("-->index:进入index首页");
        return "/index_main";
    }
}
