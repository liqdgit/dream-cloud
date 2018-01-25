package com.dream.admin.web.interceptor;

import com.dream.admin.web.service.ApiManagerService;
import com.dream.bean.admin.ApiManager;
import com.dream.core.common.web.DreamAuthInterceptor;
import com.dream.core.common.wrapper.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>Title:      AuthInterceptor. </p>
 * <p>Description 拦截器 </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/22 16:40
 */
@Service
public class AuthInterceptor extends DreamAuthInterceptor {

    @Autowired
    private ApiManagerService apiManagerService;


    @Override
    public boolean pre(HttpServletRequest request, HttpServletResponse response, Object handler) {
        return true;
    }

    @Override
    public void post(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    @Override
    public void after(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }

    @Override
    public boolean api() {
        return true;
    }

    @Override
    public Wrapper<ApiManager> getApiInfo(String methodName) {
        return apiManagerService.queryByMethodName(methodName);
    }
}
