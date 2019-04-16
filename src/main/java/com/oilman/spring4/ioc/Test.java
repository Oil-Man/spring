package com.oilman.spring4.ioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 描述：测试类
 * Created by wangcw on 2019/4/8.
 */
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext aca = new AnnotationConfigApplicationContext(SpringIocConfiguration.class);
        UseFunctionService useFunctionService = aca.getBean(UseFunctionService.class);
        useFunctionService.useFun();
        System.out.println(aca.getBean(FunctionService.class) == aca.getBean(FunctionService.class));
        aca.close();
    }
}
