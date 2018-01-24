package com.dream.admin.service.service;

import com.dream.admin.service.mapper.ApiManagerMapper;
import com.dream.bean.admin.ApiManager;
import com.dream.core.common.base.DreamDaoService;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void insertInit(List<ApiManager> list, String serviceName) throws Exception {
        List<ApiManager> dataList = this.queryByServiceName(serviceName);

        if(CollectionUtils.isNotEmpty(dataList)){
            List<ApiManager> intersection = Lists.newArrayList();
            for (ApiManager item: dataList){
                for (ApiManager l: list){
                    if(item.getMethodName().equals(l.getMethodName())){
                        intersection.add(item);
                    }
                }
            }
            dataList.removeAll(intersection);
            for (ApiManager item: dataList){
                ApiManager update = new ApiManager();
                update.setId(item.getId());
                update.setVersion(item.getVersion());
                update.setStatus(ApiManager.Status.OFFLINE.getKey());
                this.updateByIdSelective(update);
            }
        }

        if(CollectionUtils.isNotEmpty(list)){
            for (ApiManager apiManager: list){
                ApiManager api = apiManagerMapper.queryByMethodName(apiManager.getMethodName());
                if(api == null){
                    apiManager.preInsert();
                    apiManager.setServiceName(serviceName);
                    this.insert(apiManager);
                }else{
                    if(api.getStatus().equals(ApiManager.Status.OFFLINE.getKey())){
                        apiManager.setStatus(ApiManager.Status.OPEN.getKey());
                    }
                    apiManager.setId(api.getId());
                    apiManager.setVersion(api.getVersion());
                    this.updateByIdSelective(apiManager);
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

    /**
     * <p>Title:      根据服务名称查询. </p>
     * <p>Description </p>
     *
     * @param         serviceName
     * @author        <a href="liqd163@163.com"/>李清栋</a>
     * @CreateDate    2018/1/18 14:19
     * @return
     */
    public List<ApiManager> queryByServiceName(String serviceName){
        return apiManagerMapper.queryByServiceName(serviceName);
    }

    /**
     * <p>Title:      根据方法名查询. </p>
     * <p>Description </p>
     *
     * @param         methodName
     * @author        <a href="liqd163@163.com"/>李清栋</a>
     * @CreateDate    2018/1/12 17:28
     * @return
     */
    public ApiManager queryByMethodName(String methodName){
        return apiManagerMapper.queryByMethodName(methodName);
    }
}
