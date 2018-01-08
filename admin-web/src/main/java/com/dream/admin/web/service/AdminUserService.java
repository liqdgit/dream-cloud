package com.dream.admin.web.service;

import com.dream.admin.service.api.admin.AdminUserServiceApi;
import com.dream.admin.web.fallback.AdminUserFallback;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * <p>Title:      AdminUserService. </p>
 * <p>Description 管理员用户 </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/4 13:52
 */
@FeignClient(value = "${service.admin}", fallback = AdminUserFallback.class)
public interface AdminUserService extends AdminUserServiceApi {
}
