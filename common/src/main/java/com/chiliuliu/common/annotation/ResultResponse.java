package com.chiliuliu.common.annotation;

import java.lang.annotation.*;


/**
 * 自定义全局统一返回值注解（弃用）
 *
 * @Author: liuyu
 * @Date: 2020/11/24 14:19
 **/
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ResultResponse {
}
