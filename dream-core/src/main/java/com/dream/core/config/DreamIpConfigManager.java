package com.dream.core.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

/**
 * <p>Title:      DreamIPConfigManager. </p>
 * <p>Description IP </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/23 13:43
 */
@Data
@Configuration
@ConfigurationProperties(prefix = DreamIpConfigManager.PREFIX)
public class DreamIpConfigManager {

    public static final String PREFIX = "dream";

    private Map<String, List<String>> ip;

    @Value("${spring.cloud.client.ipAddress}")
    private String applicationIp;
}
