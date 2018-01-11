package com.dream.admin.web.service;

import com.dream.admin.web.fallback.HelloServiceFallback;
import com.dream.admin.service.api.hello.HelloServiceApi;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * <p>Title:      HelloService. </p>
 * <p>Description Hello  </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2017/12/25 11:13
 */
@FeignClient(value = "${dream.application.name.manager-service-server}", fallback = HelloServiceFallback.class)
public interface HelloService extends HelloServiceApi {

}
