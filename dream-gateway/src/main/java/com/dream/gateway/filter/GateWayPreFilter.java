package com.dream.gateway.filter;

import com.dream.core.annotation.WebLog;
import com.netflix.zuul.ZuulFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @WebLog
    @Override
    public Object run() {
        return null;
    }
}
