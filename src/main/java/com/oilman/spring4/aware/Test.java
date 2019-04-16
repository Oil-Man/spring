package com.oilman.spring4.aware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 描述：测试类
 * Created by wangcw on 2019/4/10.
 */
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AwareConfiguration.class);
        MyBean myBean = context.getBean(MyBean.class);
        myBean.print();
        context.close();
    }
}
