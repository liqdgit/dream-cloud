package com.dream.bean.base;

import lombok.Data;

import java.util.Date;
import java.util.Random;

/**
 * <p>Title:      BaseBean. </p>
 * <p>Description 实体类基类 </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/4 11:45
 */
@Data
public class BaseBean {

    private Integer id;

    /**
     * 创建人id
     */
    private Integer createUserId;

    /**
     * 创建人姓名
     */
    private String createUserName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人id
     */
    private Integer updateUserId;

    /**
     * 更新人姓名
     */
    private String updateUserName;

    /**
     * 更新人时间
     */
    private Date updateTime;

    /**
     * 版本号
     */
    private Integer version;

    /**
     * 是否删除
     */
    private Integer isDelete;


    public void preInsert(){
        Date now = new Date();
        Random random = new Random(100000);
        this.id = random.nextInt();
        this.createUserId = 1;
        this.createTime = now;
        this.createUserName = "1";
        this.updateUserId = 1;
        this.updateTime = now;
        this.updateUserName = "1";
        this.version = 0;
        this.isDelete = 0;
    }
}
