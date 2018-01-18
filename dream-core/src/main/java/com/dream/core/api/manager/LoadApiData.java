package com.dream.core.api.manager;

import com.dream.bean.admin.ApiManager;
import com.dream.core.annotation.DreamRequest;
import com.dream.core.util.ReflectAnnotationMethodUtil;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;
import org.assertj.core.util.Maps;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public static ArrayList<ApiManager> format(List<Method> methodList, Map<RequestMappingInfo, HandlerMethod> map){
        ArrayList<ApiManager> list = Lists.newArrayList();
        Map<String, Map.Entry<RequestMappingInfo, HandlerMethod>> requestMap = formatRequestMapping(map);
        if(methodList != null && methodList.size() > 0){
            for (Method method: methodList){
                String clazzName = method.getDeclaringClass().getName();
                String methodName = method.toGenericString();
                Map.Entry<RequestMappingInfo, HandlerMethod> methodMap = requestMap.get(methodName);
                RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
                if(requestMapping != null){
                    String requestMethod = StringUtils.join(requestMapping.method(), ",");
                    ApiManager apiManager = new ApiManager();
                    apiManager.setClassName(clazzName);
                    apiManager.setMethodName(methodName);
                    apiManager.setRequestMethod(requestMethod);
                    RequestMappingInfo info = methodMap.getKey();
                    PatternsRequestCondition p = info.getPatternsCondition();
                    List<String> urls = Lists.newArrayList(p.getPatterns());
                    apiManager.setUri(StringUtils.join(urls, ","));
                    apiManager.preInsert();
                    list.add(apiManager);
                }else{
                    continue;
                }
            }
        }
        return list;
    }

    public static Map<String, Map.Entry<RequestMappingInfo, HandlerMethod>> formatRequestMapping(Map<RequestMappingInfo, HandlerMethod> map){
        Map<String, Map.Entry<RequestMappingInfo, HandlerMethod>> resultMap = new HashMap<>(16);
        for (Map.Entry<RequestMappingInfo, HandlerMethod> m : map.entrySet()) {
            HandlerMethod method = m.getValue();
            resultMap.put(method.getMethod().toGenericString(), m);
        }
        return resultMap;
    }
}
