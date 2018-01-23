package com.dream.gateway.filter;

import com.dream.core.config.DreamApplicationNameConfigManager;
import com.dream.core.config.DreamIpConfigManager;
import com.dream.core.config.DreamPortConfigManager;
import com.netflix.zuul.ZuulFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>Title:      GateWayPreFilter. </p>
 * <p>Description 统一网关过滤器 </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/9 13:26
 */
@Component
public class GateWayPreFilter extends ZuulFilter {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DreamPortConfigManager dreamPortConfigManager;
    @Autowired
    private DreamIpConfigManager dreamIpConfigManager;
    @Autowired
    private DreamApplicationNameConfigManager dreamApplicationNameConfigManager;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        logger.info("dreamApplicationNameConfigManager:{}",dreamApplicationNameConfigManager);
        logger.info("dreamPortConfigManager:{}",dreamPortConfigManager);
        logger.info("dreamIPConfigManager:{}", dreamIpConfigManager);
        return null;
    }
}
