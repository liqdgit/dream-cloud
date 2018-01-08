package com.dream.admin.service.web;

import com.dream.admin.service.api.hello.HelloServiceApi;
import com.dream.core.annotation.WebLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * <p>Title:      HelloController. </p>
 * <p>Description Hello </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2017/12/25 14:44
 */
@RestController
public class HelloController implements HelloServiceApi {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @WebLog
    @Override
    public String hello(@RequestParam("name") String name) {
        int sleepTime = new Random().nextInt(6000);
        logger.info("sleepTime:" + sleepTime);
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("你好，"+name);
        return "你好，"+name;
    }
}
