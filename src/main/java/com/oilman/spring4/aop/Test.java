package com.oilman.spring4.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 描述：测试类
 * Created by wangcw on 2019/4/8.
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext context =  new AnnotationConfigApplicationContext(SpringAopConfiguration.class);
        DemoAnnotationService demoAnnotationService = context.getBean(DemoAnnotationService.class);
        DemoMethodService demoMethodService = context.getBean(DemoMethodService.class);
        demoAnnotationService.add();
        demoMethodService.add();
    }
}
