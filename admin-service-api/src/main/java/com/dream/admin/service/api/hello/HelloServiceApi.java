package com.dream.admin.service.api.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * <p>Title:      HelloServiceApi. </p>
 * <p>Description Hello Api </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2017/12/25 14:34
 */
@RequestMapping("/hello")
public interface HelloServiceApi {

    /**
     * <p>Title:      hello. </p>
     * <p>Description </p>
     *
     * @param         name
     * @author        <a href="liqd163@163.com"/>李清栋</a>
     * @CreateDate    2017/12/25 14:34
     * @return
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);
}
