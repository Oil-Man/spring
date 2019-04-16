package com.oilman.spring4.spel;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 描述：测试类
 * Created by wangcw on 2019/4/8.
 */
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ElConfiguration.class);
        context.getBean(ElConfiguration.class).printResource();
        context.close();
    }
}
