package com.dream.admin.web.interceptor;

import com.dream.admin.web.service.ApiManagerService;
import com.dream.bean.admin.ApiManager;
import com.dream.core.common.request.UriMatchHandlerMapping;
import com.dream.core.common.util.CheckArgumentUtil;
import com.dream.core.common.web.DreamApplicationContext;
import com.dream.core.common.wrapper.WrapMapper;
import com.dream.core.common.wrapper.Wrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.RequestMatchResult;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * <p>Title:      AuthInterceptor. </p>
 * <p>Description 拦截器 </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/22 16:40
 */
@Service
public class AuthInterceptor implements HandlerInterceptor {

    protected Logger logger = LoggerFactory.getLogger(HandlerInterceptor.class);

    @Autowired
    private ApiManagerService apiManagerService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
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
            Wrapper<ApiManager> wrapper = apiManagerService.queryByMethodName(method.toGenericString());
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

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }

    private void handleException(HttpServletRequest req, HttpServletResponse res, String msg) throws IOException {
        res.resetBuffer();
        res.setCharacterEncoding("UTF-8");
        res.setContentType("application/json");
        res.setLocale(new java.util.Locale("zh","CN"));
        res.getWriter().write(msg);
        res.flushBuffer();
    }
}
