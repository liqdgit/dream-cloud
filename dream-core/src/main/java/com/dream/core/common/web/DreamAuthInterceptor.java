package com.dream.core.common.web;

import com.dream.bean.admin.ApiManager;
import com.dream.core.common.request.UriMatchHandlerMapping;
import com.dream.core.common.wrapper.WrapMapper;
import com.dream.core.common.wrapper.Wrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * <p>Title:      DreamAuthInterceptor. </p>
 * <p>Description 拦截器 </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/25 10:54
 */
public abstract class DreamAuthInterceptor implements HandlerInterceptor {

    protected Logger logger = LoggerFactory.getLogger(HandlerInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(api()){
            boolean check = checkApi(request, response);
            if(!check){
                return false;
            }
        }
        return pre(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        post(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        after(request, response, handler, ex);
    }
    
    
    public abstract boolean pre(HttpServletRequest request, HttpServletResponse response, Object handler);
    
    public abstract void post(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView);
    
    public abstract void after(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex);
    
    /**
     * <p>Title:      是否Api服务，为true则进行Api鉴权. </p>
     * <p>Description </p>
     *
     * @param         
     * @author        <a href="liqd163@163.com"/>李清栋</a>
     * @CreateDate    2018/1/25 10:58
     * @return        
     */
    public abstract boolean api();

    /**
     * <p>Title:      获取Api信息. </p>
     * <p>Description </p>
     *
     * @param         methodName
     * @author        <a href="liqd163@163.com"/>李清栋</a>
     * @CreateDate    2018/1/25 11:01
     * @return
     */
    public abstract Wrapper<ApiManager> getApiInfo(String methodName);

    /**
     * <p>Title:      接口校验. </p>
     * <p>Description </p>
     *
     * @param
     * @author        <a href="liqd163@163.com"/>李清栋</a>
     * @CreateDate    2018/1/25 11:06
     * @return
     */
    private boolean checkApi(HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.info("--->进入拦截器，进行接口验证");
        try {
            ApplicationContext applicationContext = DreamApplicationContext.getApplicationContext();
            RequestMappingHandlerMapping requestMappingHandlerMapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
            Map<RequestMappingInfo, HandlerMethod> handlerMethodMap = requestMappingHandlerMapping.getHandlerMethods();
            UriMatchHandlerMapping uriMatchHandlerMapping = new UriMatchHandlerMapping(handlerMethodMap);
            UriMatchHandlerMapping.Match match = uriMatchHandlerMapping.lookupHandlerMethod(request);
            if(match == null){
                handleException(request, response, WrapMapper.error(Wrapper.ResultCode.NOT_FOUND).toString());
            }
            Method method = match.getHandlerMethod().getMethod();
            Wrapper<ApiManager> wrapper = getApiInfo(method.toGenericString());
            if(wrapper == null){
                handleException(request, response, WrapMapper.error(Wrapper.ResultCode.NOT_FOUND).toString());
            }
            if (!wrapper.is()) {
                handleException(request, response, WrapMapper.error(Wrapper.ResultCode.ERROR).toString());
            }
            ApiManager apiManager = wrapper.getResult();
            if(apiManager.getStatus().equals(ApiManager.Status.OPEN.getKey())){
                return true;
            }
            handleException(request, response,
                    WrapMapper.error(Wrapper.ResultCode.FORBIDDEN, ApiManager.Status.getValue(apiManager.getStatus())).toString());
        } catch (Exception e) {
            logger.error("验证异常：", e);
            handleException(request, response, WrapMapper.error(Wrapper.ResultCode.ERROR).toString());
        }
        return false;
    }

    /**
     * <p>Title:      设置响应信息. </p>
     * <p>Description </p>
     *
     * @param         
     * @author        <a href="liqd163@163.com"/>李清栋</a>
     * @CreateDate    2018/1/25 11:06
     * @return        
     */
    public void handleException(HttpServletRequest req, HttpServletResponse res, String msg) throws IOException {
        res.resetBuffer();
        res.setCharacterEncoding("UTF-8");
        res.setContentType("application/json");
        res.setLocale(new java.util.Locale("zh","CN"));
        res.getWriter().write(msg);
        res.flushBuffer();
    }
}
