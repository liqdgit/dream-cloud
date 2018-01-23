package com.dream.core.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * <p>Title:      DreamApplicationNameConfigManager. </p>
 * <p>Description 应用名称 </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/18 14:23
 */
@Data
@Configuration
@ConfigurationProperties(prefix = DreamApplicationNameConfigManager.PREFIX)
public class DreamApplicationNameConfigManager {

    public static final String PREFIX = "dream.application";

    private Map<String, String> name;

    @Value("${spring.application.name}")
    private String applicationName;
}
