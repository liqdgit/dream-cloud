package com.dream.core.common.jwts;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title:      DreamToken. </p>
 * <p>Description JWT token </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/5 17:10
 */
@Data
public class DreamToken implements Serializable {

    private static final long serialVersionUID = 6276470016107496721L;

    /**
     * id
     */
    private String subject;

    /**
     * 数据key
     */
    private String dataKey;

    /**
     * data
     */
    private String data;

    /**
     * 签发时间
     */
    private Date now;

    /**
     * 过期时间
     */
    private Date exp;

    /**
     * 私钥
     */
    private String tokenKey;
}
