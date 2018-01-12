package com.dream.core.api.manager;

import com.dream.bean.admin.ApiManager;
import com.dream.core.annotation.DreamRequest;
import com.dream.core.util.ReflectAnnotationMethodUtil;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title:      LoadApiData. </p>
 * <p>Description 加载接口数据 </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/11 16:38
 */
public class LoadApiData {

    public static List<Method> getApi(String pkgName){
        List<Method> methodList = ReflectAnnotationMethodUtil.getClassList(pkgName, true, DreamRequest.class);
        return methodList;
    }

    public static ArrayList<ApiManager> format(List<Method> methodList){
        ArrayList<ApiManager> list = Lists.newArrayList();
        if(methodList != null && methodList.size() > 0){
            for (Method method: methodList){
                String clazzName = method.getDeclaringClass().getName();
                String methodName = method.toGenericString();
                RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
                if(requestMapping != null){
                    String uri = StringUtils.join(requestMapping.value(), ",");
                    String requestMethod = StringUtils.join(requestMapping.method(), ",");
                    ApiManager apiManager = new ApiManager();
                    apiManager.setClassName(clazzName);
                    apiManager.setMethodName(methodName);
                    apiManager.setRequestMethod(requestMethod);
                    apiManager.setUri(uri);
                    apiManager.preInsert();
                    list.add(apiManager);
                }else{
                    continue;
                }
            }
        }
        return list;
    }
}
