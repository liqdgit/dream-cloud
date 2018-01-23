package com.dream.core.common.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>Title:      WebUtil. </p>
 * <p>Description TODO </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/9 11:39
 */
public class WebUtil {
    
    /**
     * <p>Title:      获取当前request对象. </p>
     * <p>Description </p>
     *
     * @param         
     * @author        <a href="liqd163@163.com"/>李清栋</a>
     * @CreateDate    2018/1/9 11:40
     * @return        
     */
    public static HttpServletRequest getRequest(){
        ServletRequestAttributes ra= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request =  ra.getRequest();
        return request;
    }

    /**
     * <p>Title:      获取当前response对象. </p>
     * <p>Description </p>
     *
     * @param         
     * @author        <a href="liqd163@163.com"/>李清栋</a>
     * @CreateDate    2018/1/9 12:36
     * @return        
     */
    public static HttpServletResponse getResponse(){
        ServletRequestAttributes ra= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response =  ra.getResponse();
        return response;
    }
}
