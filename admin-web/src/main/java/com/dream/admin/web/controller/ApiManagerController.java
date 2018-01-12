package com.dream.admin.web.controller;

import com.dream.admin.web.service.ApiManagerService;
import com.dream.bean.admin.ApiManager;
import com.dream.core.api.manager.LoadApiData;
import com.dream.core.base.BaseController;
import com.dream.core.common.ApiManagerConstant;
import com.dream.core.util.JacksonUtil;
import com.dream.core.wrapper.WrapMapper;
import com.dream.core.wrapper.Wrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title:      ApiManagerController. </p>
 * <p>Description api 管理 </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/12 16:48
 */
@RestController
@RequestMapping(value = "${managerUrlPrefix}/api/manager", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ApiManagerController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ApiManagerService apiManagerService;

    @RequestMapping("init")
    public Wrapper init(){
        try {
            List<Method> methodList = ApiManagerConstant.getInstance().getApi();
            ArrayList<ApiManager> list = LoadApiData.format(methodList);
            Wrapper wrapper = apiManagerService.insert(list);
            return wrapper;
        } catch (Exception e) {
            logger.error("-->init 初始化接口异常{}", e);
            return WrapMapper.error();
        }
    }
}
