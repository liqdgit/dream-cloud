package com.dream.admin.web.interceptor;

import com.dream.core.common.Constant;
import com.dream.core.exception.DreamException;
import com.dream.core.jwts.DreamJWT;
import com.dream.core.jwts.DreamToken;
import com.dream.core.util.CookieUtil;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * <p>Title:      AuthInterceptor. </p>
 * <p>Description 鉴权 拦截器 </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/5 18:23
 */
@Service
public class AuthInterceptor implements HandlerInterceptor {

    @Autowired
    private Constant constant;

    protected Logger logger = LoggerFactory.getLogger(HandlerInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        final String method = "OPTIONS";
        if(method.equals(request.getMethod())){
            return false;
        }
        if(true){
            return true;
        }
        if("/admin/login".equals(request.getRequestURI())){
            return true;
        }

        try {
            Cookie[] cookies = request.getCookies();
            boolean is = redirect(cookies, response);
            if(!is){
                return false;
            }
            String token = null;
            if(cookies != null){
                for (Cookie cookie: cookies){
                    if(constant.getCAUTK().equals(cookie.getName())){
                        token = cookie.getValue();
                    }
                }
            }

            is = redirect(token, response);
            if(!is){
                return false;
            }
            Claims claims = DreamJWT.parseJWT(constant.getAUTK(), token);
            is = redirect(claims, response);
            if(!is){
                return false;
            }
            Date exp = claims.getExpiration();
            Date now = new Date();
            if(exp.getTime() - now.getTime() > Constant.DAY_TIME){
                DreamToken dreamToken = new DreamToken();
                dreamToken.setNow(now);
                exp = new Date(now.getTime() + Constant.DAY_TIME);
                dreamToken.setExp(exp);
                dreamToken.setData(claims.get(Constant.TOKEN_DATA_KEY).toString());
                dreamToken.setDataKey(Constant.TOKEN_DATA_KEY);
                dreamToken.setSubject(claims.getSubject());
                dreamToken.setTokenKey(constant.getAUTK());
                String newToken = DreamJWT.createJWT(dreamToken);
                CookieUtil.setCookie(constant.getCAUTK(), newToken, constant.getDomain(), Constant.PATH, response);
            }
        } catch (IOException e) {
            logger.error("鉴权失败", e.getMessage(), e);
            return false;
        } catch (DreamException e) {
            logger.error("鉴权失败", e.getMessage(), e);
            return false;
        }

        return true;
    }

    public boolean redirect(Object obj, HttpServletResponse response) throws IOException {
        if(obj == null){
            response.sendRedirect("/admin/login");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
