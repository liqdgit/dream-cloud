package com.dream.core.common.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DreamRequest {

    DreamRequestType type() default DreamRequestType.WEB;
}
