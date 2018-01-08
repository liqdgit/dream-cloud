package com.dream.bean.admin;

import com.dream.bean.base.BaseBean;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>Title:      AdminUser. </p>
 * <p>Description 管理员用户类 </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/4 11:31
 */
@Data
public class AdminUser extends BaseBean implements Serializable {

    private static final long serialVersionUID = 1944562967238378382L;
    /**
     * 姓名
     */
    private String userName;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 登录密码
     */
    private String loginPwd;

    /**
     * token私钥
     */
    private String tokenKey;

    @Override
    public String toString() {
        return "AdminUser{" +
                "userName='" + userName + '\'' +
                ", loginName='" + loginName + '\'' +
                ", loginPwd='" + loginPwd + '\'' +
                ", tokenKey='" + tokenKey + '\'' +
                "} " + super.toString();
    }
}
