package com.dream.bean.admin;

import com.dream.bean.base.BaseBean;
import lombok.Data;

import java.util.*;


/**
 * <p>Title:      ApiManager. </p>
 * <p>Description Api管理 </p>
 *
 * @author <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate 2018/1/11 17:23
 */
@Data
public class ApiManager extends BaseBean {

    private String className;

    private String methodName;

    private String uri;

    private String requestMethod;

    private Integer status;

    private String serviceName;


    public enum Status {

        OPEN(10, "开放"),
        OFFLINE(20, "下线"),
        CLOSE(30, "关闭"),;

        Integer key;
        String value;

        Status(Integer key, String value) {
            this.key = key;
            this.value = value;
        }

        public Integer getKey() {
            return key;
        }

        public void setKey(Integer key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        /**
         * 获取key获取value
         *
         * @param key key
         * @return value
         */
        public static String getValue(String key) {
            for (Status ele : Status.values()) {
                if (key.equals(ele.getKey())) {
                    return ele.getValue();
                }
            }
            return null;
        }

        /**
         * 根据key获取该对象
         *
         * @param key key
         * @return this
         */
        public static Status getEnum(String key) {
            for (Status ele : Status.values()) {
                if (key.equals(ele.getKey())){
                    return ele;
                }
            }
            return null;
        }

        /**
         * 获取List集合
         *
         * @return List
         */
        public static List<Status> getList() {
            return Arrays.asList(Status.values());
        }


        /**
         * 获取map类型集合
         *
         * @return Map类型List集合
         */
        public static List<Map<String, String>> getMap2List() {
            List<Map<String, String>> list = new ArrayList<>();
            for (Status ele : Status.values()) {
                Map<String, String> map = new HashMap<>(16);
                map.put("key", ele.getKey().toString());
                map.put("value", ele.getValue());
                list.add(map);
            }
            return list;
        }
    }
}