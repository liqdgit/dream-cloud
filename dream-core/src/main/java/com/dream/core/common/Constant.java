package com.dream.core.common;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * <p>Title:      Constant. </p>
 * <p>Description 常量类 </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/8 15:47
 */
@Data
@Configuration
@ConfigurationProperties(prefix = Constant.PREFIX)
public class Constant {

    public static final String PREFIX = "dream";

    private String jwtKey;

    private String tokenCookieKey;

    private String domain;

    private String tokenDataKey;

    public static final String PATH = "/";

    public static final Long SECOND_TIME = 1000L;

    public static final Long MINUTE_TIME = SECOND_TIME * 60;

    public static final Long HOUR_TIME = MINUTE_TIME * 60;

    public static final Long DAY_TIME = HOUR_TIME * 24;

    public static final String METHOD_POST = "POST";

    public static final String METHOD_GET = "GET";

    public static final String ajaxType = "XMLHttpRequest";
}
