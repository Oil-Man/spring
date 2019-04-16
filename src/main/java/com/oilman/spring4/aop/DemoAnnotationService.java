package com.oilman.spring4.aop;

import org.springframework.stereotype.Service;

/**
 * 描述：基于注解规则的被拦截类
 * Created by wangcw on 2019/4/8.
 */
@Service
public class DemoAnnotationService {

    @Action("对使用Action注解的方法进行注解式拦截的add操作")
    public void add(){}
}
