package com.dream.admin.service.web;

import com.dream.admin.service.api.hello.HelloServiceApi;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * <p>Title:      HelloController. </p>
 * <p>Description Hello </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2017/12/25 14:44
 */
@RestController
public class HelloController implements HelloServiceApi {

    private final Logger logger = Logger.getLogger(getClass().toString());

    @Override
    public String hello(@RequestParam("name") String name) {
        logger.info("你好，"+name);
        return "你好，"+name;
    }
}
