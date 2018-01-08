package com.dream.core.jwts;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * <p>Title:      DreamJWT. </p>
 * <p>Description JWT token </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/5 17:18
 */
public class DreamJWT {

    /**
     * <p>Title:      创建 jwt token. </p>
     * <p>Description </p>
     *
     * @param         
     * @author        <a href="liqd163@163.com"/>李清栋</a>
     * @CreateDate    2018/1/5 17:32
     * @return        
     */
    public static String createJWT(DreamToken dreamToken){
        String token = Jwts.builder()
                .setSubject(dreamToken.getSubject())
                .claim(dreamToken.getDataKey(), dreamToken.getData())
                .setIssuedAt(dreamToken.getNow())
                .setExpiration(dreamToken.getExp())
                .signWith(SignatureAlgorithm.HS256, dreamToken.getTokenKey()).compact();
        return token;
    }

    /**
     * <p>Title:      解密 jwt token. </p>
     * <p>Description </p>
     *
     * @param         
     * @author        <a href="liqd163@163.com"/>李清栋</a>
     * @CreateDate    2018/1/5 17:32
     * @return        
     */
    public static Claims parseJWT(String tokenKey, String token){
        final Claims claims = Jwts.parser().setSigningKey(tokenKey).parseClaimsJws(token).getBody();
        return claims;
    }
}
