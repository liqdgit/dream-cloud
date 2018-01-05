package com.dream.admin.web.controller;

import com.dream.admin.web.service.HelloService;
import com.dream.core.annotation.WebLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 * <p>Title:      HelloController. </p>
 * <p>Description Hello </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2017/12/25 14:59
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class HelloController {

    @Autowired
    private HelloService helloService;

    @WebLog
    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String hello(){
        return helloService.hello("李清栋");
    }
}
