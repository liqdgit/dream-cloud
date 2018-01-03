package com.dream.admin.web.fallback;

import com.dream.admin.web.service.HelloService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>Title:      HelloServiceFallback. </p>
 * <p>Description Hello 服务降级类 </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2017/12/25 18:19
 */
@Component
@RequestMapping("/fallback")
public class HelloServiceFallback implements HelloService {

    @Override
    public String hello(@RequestParam("name") String name) {
        return "error";
    }
}
