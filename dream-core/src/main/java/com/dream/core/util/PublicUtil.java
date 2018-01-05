package com.dream.core.util;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>Title:      PublicUtil. </p>
 * <p>Description 公用工具类 </p>
 * <p>Company:    liqingdong </p>
 *
 * @Author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2017/7/7 11:08
 */
public class PublicUtil {
    
    /**
     * <p>Title:      获取用户远程地址. </p>
     * <p>Description </p>
     *
     * @param         
     * @Author        <a href="liqd163@163.com"/>李清栋</a>
     * @CreateDate    2017/7/7 11:09
     * @return        
     */
    public static String getRemoteAddr(HttpServletRequest request){
        String remoteAddr = request.getHeader("X-Real-IP");
        if (!StringUtils.isEmpty(remoteAddr)) {
            remoteAddr = request.getHeader("X-Forwarded-For");
        }else if (!StringUtils.isEmpty(remoteAddr)) {
            remoteAddr = request.getHeader("Proxy-Client-IP");
        }else if (!StringUtils.isEmpty(remoteAddr)) {
            remoteAddr = request.getHeader("WL-Proxy-Client-IP");
        }

        if(StringUtils.isEmpty(remoteAddr)){
            remoteAddr = request.getRemoteAddr();
            if(StringUtils.isNotEmpty(remoteAddr) && "0:0:0:0:0:0:0:1".equals(remoteAddr)){
                remoteAddr = "127.0.0.1";
            }else {
                remoteAddr = request.getRemoteAddr();
            }
        }

        return remoteAddr;
    }
}
