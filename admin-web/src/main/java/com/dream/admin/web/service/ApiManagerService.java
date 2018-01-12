package com.dream.admin.web.service;

import com.dream.admin.service.api.admin.ApiManagerServiceApi;
import com.dream.admin.web.fallback.ApiManagerFallback;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * <p>Title:      ApiManagerService. </p>
 * <p>Description TODO </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/11 17:27
 */
@FeignClient(value = "${dream.application.name.manager-service-server}", fallback = ApiManagerFallback.class)
public interface ApiManagerService extends ApiManagerServiceApi {
}
