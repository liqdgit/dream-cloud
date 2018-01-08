package com.dream.core.common;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

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

    public static final String PREFIX = "dream.admin";

    private String AUTK;

    private String CAUTK;

    private String domain;

    public static final String TOKEN_DATA_KEY = "adminUser";

    public static final String PATH = "/";

    public static final Long SECOND_TIME = 1000L;

    public static final Long MINUTE_TIME = SECOND_TIME * 60;

    public static final Long HOUR_TIME = MINUTE_TIME * 60;

    public static final Long DAY_TIME = HOUR_TIME * 24;
}
