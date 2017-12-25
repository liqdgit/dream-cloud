package com.dream.admin.web.constant;

/**
 * <p>Title:      ServiceName. </p>
 * <p>Description 服务名称 </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2017/12/25 15:36
 */
public enum ServiceName {

    ADMIN("后台管理", "ADMIN-SERVICE"),;

    private String desc;

    private String value;

    ServiceName(String desc, String value){
        this.desc = desc;
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
