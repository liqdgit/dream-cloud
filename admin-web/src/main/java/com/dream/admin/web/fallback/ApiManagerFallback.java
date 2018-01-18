package com.dream.admin.web.fallback;

import com.dream.admin.web.service.ApiManagerService;
import com.dream.bean.admin.ApiManager;
import com.dream.core.wrapper.WrapMapper;
import com.dream.core.wrapper.Wrapper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title:      ApiManagerFallback. </p>
 * <p>Description TODO </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/11 17:28
 */
@Component
@RequestMapping("/fallback")
public class ApiManagerFallback implements ApiManagerService {


    @Override
    public Wrapper insert(List<ApiManager> list, String serviceName) {
        return WrapMapper.error();
    }
}
