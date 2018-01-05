package com.dream.core.aop;

import com.dream.core.util.PublicUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.util.Arrays;

/**
 * <p>Title:      WebLogAspect. </p>
 * <p>Description web请求记录日志 </p>
 * <p>Company:    liqingdong </p>
 *
 * @author <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate 2017/7/7 9:25
 */
@Aspect
@Component
public class WebRequestAspect {

    private Logger logger = LoggerFactory.getLogger(WebRequestAspect.class);

    private static final ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    @Pointcut("@annotation(com.dream.core.annotation.WebLog)")
    public void webLog() {
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        logger.info("------------------------------------------------start-------------------------------------------------");
        threadLocal.set(System.currentTimeMillis());
        logger.info("---> start time："+ System.currentTimeMillis());
        logger.info("---> 请求信息：");
        logger.info("url : " + request.getRequestURL().toString());
        logger.info("http_method : " + request.getMethod());
        logger.info("ip : " + PublicUtil.getRemoteAddr(request));
        logger.info("class_method : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("params : " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = attributes.getResponse();

        // 处理完请求，返回内容
        Long nowTime = System.currentTimeMillis();
        Long l = nowTime - threadLocal.get();
        logger.info("---> end time："+ nowTime);
        logger.info("---> 响应信息：");
        logger.info("response : " + ret);
        logger.info("status : " + response.getStatus());
        logger.info("总耗时 : " + l);
        logger.info("------------------------------------------------end-------------------------------------------------");
    }
}
