package com.dream.user.auth.filter;

import com.dream.core.annotation.WebLog;
import com.dream.core.common.Constant;
import com.dream.core.util.JacksonUtil;
import com.dream.core.util.WebUtil;
import com.dream.core.wrapper.WrapMapper;
import com.dream.core.wrapper.Wrapper;
import com.dream.user.auth.auth.TokenAuth;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>Title:      AuthFilter. </p>
 * <p>Description 鉴权过滤器 </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/9 11:29
 */
@Component
public class AuthFilter extends ZuulFilter {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TokenAuth tokenAuth;

    @Autowired
    private Constant constant;

    @Value("${server.port}")
    private Integer port;


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
//        if(true){
//            return null;
//        }
        logger.info("--> 过滤器{}，端口：{}", filterOrder(), port);

        HttpServletRequest request = WebUtil.getRequest();
        HttpServletResponse response = WebUtil.getResponse();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setLocale(new java.util.Locale("zh","CN"));
        // 如果是进入登录页面则通过，
        if(Constant.METHOD_GET.toUpperCase().equals(request.getMethod().toUpperCase())){
            return null;
        }else{
            if("/admin/login".equals(request.getRequestURI())){
                return null;
            }
            boolean is = tokenAuth.is(request, response);
            if(!is){
                String xReq = request.getHeader("x-requested-with");
                if (StringUtils.isNotBlank(xReq) && Constant.ajaxType.equalsIgnoreCase(xReq)) {
                    FilterHelper.notAuth();
                }else{
                    try {
//                        FilterHelper.notAuth();
                        response.sendRedirect("http://localhost:8001/admin/login");
                    } catch (Exception e) {
                        FilterHelper.notAuth();
                    }
                }
            }
        }
        return null;
    }

}
