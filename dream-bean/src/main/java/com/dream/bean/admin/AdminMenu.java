package com.dream.bean.admin;

import com.dream.bean.base.BaseBean;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>Title:      AdminMenu. </p>
 * <p>Description 后台管理菜单 </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/5 11:02
 */
@Data
public class AdminMenu extends BaseBean implements Serializable {

    private static final long serialVersionUID = 9043705975110606416L;
    /**
     * 菜单名
     */
    private String name;

    /**
     * 菜单地址
     */
    private String url;

    /**
     * 父级菜单id
     */
    private Integer pid;

    /**
     * 描述
     */
    private String desc;

}