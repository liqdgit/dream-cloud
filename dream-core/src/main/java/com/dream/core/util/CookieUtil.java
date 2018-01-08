package com.dream.core.util;

import com.dream.core.exception.DreamException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * <p>Title:      CookieUtil. </p>
 * <p>Description Cookie 工具类 </p>
 *
 * @author <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate 2018/1/8 17:19
 */
public class CookieUtil {

    private static Logger logger = LoggerFactory.getLogger(CookieUtil.class);

    /**
     * <p>Title:	  setCookie. </p>
     * <p>Description 设置Cookie</p>
     *
     * @param key    cookie key
     * @param value  cookie value
     * @param path   路径
     * @param domain 域
     * @return
     * @Author <a href="liu_zhaoming@sina.cn"/>刘兆明</a>
     * @CreateDate 2017/4/18 16:39
     */
    public static void setCookie(String key, String value, String domain, String path, HttpServletResponse response) throws DreamException {
        logger.info("setCookie - 设置cookie. key={}, value={}, domain={}. path={}", key, value, domain, path);
        Cookie loginCookie = null;
        try {
            loginCookie = new Cookie(key, URLEncoder.encode(value, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new DreamException("Cookie中有乱码,encoding异常");
        }
        loginCookie.setDomain(domain);
        loginCookie.setPath(path);
        response.addCookie(loginCookie);
        logger.info("setCookie - 设置cookie. [OK]");
    }

    /**
     * <p>Title:	  setCookie. </p>
     * <p>Description 删除Cookie</p>
     *
     * @param key    cookie key
     * @param path   路径
     * @param domain 域
     * @return
     * @Author <a href="liu_zhaoming@sina.cn"/>刘兆明</a>
     * @CreateDate 2017/4/18 16:39
     */
    public static void clearCookie(String key, String domain, String path, HttpServletResponse response) {
        logger.info("clearCookie - 设置cookie. key={},  domain={}. path={}", key, domain, path);
        Cookie cookie = new Cookie(key, null);
        cookie.setDomain(domain);
        cookie.setPath(path);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        logger.info("setCookie - 设置cookie. [OK]");
    }
}
