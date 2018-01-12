package com.dream.gateway.filter;

import com.dream.core.util.JacksonUtil;
import com.dream.core.wrapper.WrapMapper;
import com.dream.core.wrapper.Wrapper;
import com.netflix.zuul.context.RequestContext;

/**
 * <p>Title:      FilterHelper. </p>
 * <p>Description 过滤器帮助类 </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/9 14:47
 */
public class FilterHelper {

    public static void notAuth() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        requestContext.setSendZuulResponse(false);
        requestContext.setResponseStatusCode(Wrapper.ResultCode.UNAUTHORIZED.getCode());
        try {
            requestContext.setResponseBody(JacksonUtil.obj2json(WrapMapper.error(Wrapper.ResultCode.UNAUTHORIZED)));
        } catch (Exception e) {
            requestContext.setResponseBody(Wrapper.ResultCode.UNAUTHORIZED.getMessage());
        }
    }
}
