package com.dream.admin.web.service;

import com.dream.admin.service.api.admin.AdminMenuServiceApi;
import com.dream.admin.web.fallback.AdminMenuFallback;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * <p>Title:      AdminMenuService. </p>
 * <p>Description TODO </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/8 11:34
 */
@FeignClient(value = "${service.admin}", fallback = AdminMenuFallback.class)
public interface AdminMenuService extends AdminMenuServiceApi {
}
