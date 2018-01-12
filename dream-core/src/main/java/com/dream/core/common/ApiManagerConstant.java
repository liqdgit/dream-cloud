package com.dream.core.common;

import org.assertj.core.util.Lists;

import java.lang.reflect.Method;
import java.util.List;

/**
 * <p>Title:      ApiManagerConstant. </p>
 * <p>Description Api常量 </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/12 16:35
 */
public class ApiManagerConstant {

    private static boolean flag = true;

    private final List<Method> methods = Lists.newArrayList();

    private static class LazyHolder {
        private static final ApiManagerConstant INSTANCE = new ApiManagerConstant();
    }

    private ApiManagerConstant() {
        if (flag) {
            flag = false;
        } else {
            throw new RuntimeException("单例模式被侵犯！");
        }
    }

    public static ApiManagerConstant getInstance() {
        return LazyHolder.INSTANCE;
    }

    public void initApi(List<Method> methods){
        this.methods.addAll(methods);
    }

    public List<Method> getApi(){
        return this.methods;
    }

}
