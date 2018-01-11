package com.dream.core.common;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Data
@Configuration
@ConfigurationProperties(prefix = DreamIPConfigManager.PREFIX)
public class DreamIPConfigManager {

    public static final String PREFIX = "dream";

    private Map<String, List<String>> ip;
}
