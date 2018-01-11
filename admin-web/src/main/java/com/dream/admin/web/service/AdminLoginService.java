package com.dream.admin.web.service;

import com.dream.admin.service.api.admin.AdminLoginServiceApi;
import com.dream.admin.web.fallback.AdminLoginFallback;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * <p>Title:      AdminLoginService. </p>
 * <p>Description TODO </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/8 16:33
 */
@FeignClient(value = "${dream.application.name.manager-service-server}", fallback = AdminLoginFallback.class)
public interface AdminLoginService extends AdminLoginServiceApi {
}
