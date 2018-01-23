package com.dream.core.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

/**
 * <p>Title:      DreamPortConfigManager. </p>
 * <p>Description 端口 </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/23 13:41
 */
@Data
@Configuration
@ConfigurationProperties(prefix = DreamPortConfigManager.PREFIX)
public class DreamPortConfigManager {

    public static final String PREFIX = "dream";

    private Map<String, List<Integer>> port;

    @Value("${server.port}")
    private Integer applicationPort;
}
