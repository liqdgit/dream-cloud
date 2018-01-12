package com.dream.admin.service.service;

import com.dream.admin.service.mapper.ApiManagerMapper;
import com.dream.bean.admin.ApiManager;
import com.dream.core.base.DreamDaoService;
import com.dream.core.util.JacksonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title:      ApiManagerService. </p>
 * <p>Description TODO </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/11 17:16
 */
@Service
public class ApiManagerService implements DreamDaoService<ApiManager> {

    @Autowired
    private ApiManagerMapper apiManagerMapper;

    @Override
    public int insert(ApiManager record) {
        return apiManagerMapper.insert(record);
    }

    public void insert(ArrayList<ApiManager> list) throws Exception {
        if(list != null && list.size()> 0){
            for (ApiManager apiManager: list){
                ApiManager api = apiManagerMapper.queryByMethodName(apiManager.getMethodName());
                if(api == null){
                    insert(apiManager);
                }else{
                    if(api.getStatus().equals(ApiManager.Status.EXPIRE.getKey())){
                        ApiManager update = new ApiManager();
                        update.setId(api.getId());
                        update.setStatus(ApiManager.Status.OPEN.getKey());
                        update.setVersion(api.getVersion());
                        apiManagerMapper.updateStatus(update);
                    }
                }
            }
        }
    }

    @Override
    public int insertSelective(ApiManager record) {
        return apiManagerMapper.insertSelective(record);
    }

    @Override
    public ApiManager queryById(Integer id) {
        return apiManagerMapper.queryById(id);
    }

    @Override
    public int updateByIdSelective(ApiManager record) {
        return apiManagerMapper.updateByIdSelective(record);
    }
}
