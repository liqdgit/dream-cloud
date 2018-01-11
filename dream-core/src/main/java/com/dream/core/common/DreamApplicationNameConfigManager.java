package com.dream.core.common;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Data
@Configuration
@ConfigurationProperties(prefix = DreamApplicationNameConfigManager.PREFIX)
public class DreamApplicationNameConfigManager {

    public static final String PREFIX = "dream.application";

    private Map<String, String> name;
}
