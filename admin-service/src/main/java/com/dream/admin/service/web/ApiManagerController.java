package com.dream.admin.service.web;

import com.dream.admin.service.api.admin.ApiManagerServiceApi;
import com.dream.admin.service.service.ApiManagerService;
import com.dream.bean.admin.ApiManager;
import com.dream.core.common.annotation.DreamRequest;
import com.dream.core.common.annotation.DreamRequestType;
import com.dream.core.common.wrapper.WrapMapper;
import com.dream.core.common.wrapper.Wrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * <p>Title:      ApiManagerController. </p>
 * <p>Description TODO </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/11 17:19
 */
@RestController
public class ApiManagerController implements ApiManagerServiceApi {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ApiManagerService apiManagerService;


    @DreamRequest(type = DreamRequestType.SERVICE)
    @Override
    public Wrapper insert(@RequestBody List<ApiManager> list, @RequestParam("serviceName") String serviceName) {
        try {
            apiManagerService.insertInit(list, serviceName);
            return WrapMapper.success();
        } catch (Exception e) {
            logger.error("--insert:添加失败", e.getMessage(), e);
            return WrapMapper.error();
        }
    }

    @DreamRequest(type = DreamRequestType.SERVICE)
    @Override
    public Wrapper<ApiManager> queryByMethodName(@RequestParam("methodName") String methodName) {
        try {
            ApiManager apiManager = apiManagerService.queryByMethodName(methodName);
            return WrapMapper.success(apiManager);
        } catch (Exception e) {
            logger.error("--queryByMethodName:查询失败", e.getMessage(), e);
            return WrapMapper.error();
        }
    }
}
