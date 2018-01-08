package com.dream.core.common;

import lombok.Data;

/**
 * <p>Title:      Page. </p>
 * <p>Description 分页 </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/8 11:23
 */
@Data
public class Page<T> {

    private Integer pageNum = 1;

    private Integer pageSize = 10;

    private T data;
}
