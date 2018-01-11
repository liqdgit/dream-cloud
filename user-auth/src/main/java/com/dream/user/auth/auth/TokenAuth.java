package com.dream.user.auth.auth;

import com.dream.core.common.Constant;
import com.dream.core.jwts.DreamJWT;
import com.dream.core.jwts.DreamToken;
import com.dream.core.util.CookieUtil;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * <p>Title:      TokenAuth. </p>
 * <p>Description 鉴权 </p>
 *
 * @author <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate 2018/1/9 13:52
 */
@Service
public class TokenAuth {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Constant constant;

    public boolean is(HttpServletRequest request, HttpServletResponse response) {
        try {
            Cookie[] cookies = request.getCookies();
            String token = null;
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (constant.getTokenCookieKey().equals(cookie.getName())) {
                        token = cookie.getValue();
                    }
                }
            } else {
                return false;
            }

            if (token == null) {
                return false;
            }

            Claims claims = DreamJWT.parseJWT(constant.getJwtKey(), token);
            Date exp = claims.getExpiration();
            Date now = new Date();
            if (exp.getTime() - now.getTime() > Constant.DAY_TIME) {
                DreamToken dreamToken = new DreamToken();
                dreamToken.setNow(now);
                exp = new Date(now.getTime() + Constant.DAY_TIME);
                dreamToken.setExp(exp);
                dreamToken.setData(claims.get(constant.getTokenDataKey()).toString());
                dreamToken.setDataKey(constant.getTokenDataKey());
                dreamToken.setSubject(claims.getSubject());
                dreamToken.setTokenKey(constant.getJwtKey());
                String newToken = DreamJWT.createJWT(dreamToken);
                CookieUtil.setCookie(constant.getTokenCookieKey(), newToken, constant.getDomain(), Constant.PATH, response);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            logger.error("鉴权失败", e.getMessage(), e);
            return false;
        }
    }
}
