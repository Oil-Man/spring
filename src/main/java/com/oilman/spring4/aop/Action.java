package com.oilman.spring4.aop;

import java.lang.annotation.*;

/**
 * 描述：aop拦截规则注解
 * Created by wangcw on 2019/4/8.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {

    String value();
}
