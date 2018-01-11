package com.dream.admin.service.service;

import com.dream.bean.admin.AdminUser;
import com.dream.core.common.Constant;
import com.dream.core.exception.DreamException;
import com.dream.core.jwts.DreamJWT;
import com.dream.core.jwts.DreamToken;
import com.dream.core.util.CheckArgumentUtil;
import com.dream.core.util.JacksonUtil;
import com.dream.core.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>Title:      LoginService. </p>
 * <p>Description 登录 </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/8 15:50
 */
@Service
public class AdminLoginService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AdminUserService adminUserService;
    @Autowired
    private Constant constant;

    public String login(String loginName, String loginPwd) throws Exception {
        CheckArgumentUtil.checkArgument(StringUtils.isNotEmpty(loginName), "登录名不能为空");
        CheckArgumentUtil.checkArgument(StringUtils.isNotEmpty(loginPwd), "登录密码不能为空");
        loginPwd = MD5Util.MD5(loginPwd);
        AdminUser user = new AdminUser();
        user.setLoginName(loginName);
        user.setLoginPwd(loginPwd);
        AdminUser adminUser = adminUserService.queryByLoginNameAndPwd(user);
        CheckArgumentUtil.checkArgument(adminUser != null, "用户名或密码错误");
        DreamToken dreamToken = new DreamToken();
        dreamToken.setSubject(loginName);
        String tokenKey = constant.getJwtKey() + adminUser.getTokenKey();
        dreamToken.setTokenKey(tokenKey);
        dreamToken.setDataKey(constant.getTokenDataKey());
        dreamToken.setData(JacksonUtil.obj2json(adminUser));
        Date now = new Date();
        dreamToken.setNow(now);
        Date exp = new Date(now.getTime() + Constant.DAY_TIME);
        dreamToken.setExp(exp);
        String token;
        try {
            token = DreamJWT.createJWT(dreamToken);
        } catch (Exception e) {
            throw new DreamException("jwt 生成token失败", e);
        }
        return token;
    }
}
