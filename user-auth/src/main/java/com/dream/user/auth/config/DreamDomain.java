package com.dream.user.auth.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * <p>Title:      DreamDomain. </p>
 * <p>Description 域名配置 </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/9 10:23
 */
@Data
@Configuration
@ConfigurationProperties(prefix = DreamDomain.PREFIX)
public class DreamDomain {

    public static final String PREFIX = "dream.domain";

    private List<String> adminDomain;

    private List<String> userDomain;
}
