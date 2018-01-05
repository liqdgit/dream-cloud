package com.dream.core.annotation;

import java.lang.annotation.*;

/**
 * <p>Title:      WebLog. </p>
 * <p>Description 服务注解 </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/5 13:45
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WebLog {
}
