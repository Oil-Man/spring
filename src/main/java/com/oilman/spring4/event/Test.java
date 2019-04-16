package com.oilman.spring4.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 描述：测试类
 * Created by wangcw on 2019/4/10.
 */
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(EventConfiguration.class);
        context.refresh();
        MyPublisher publisher = context.getBean(MyPublisher.class);
        publisher.publish(new MyEvent(new String(), "spring event"));
        context.close();
    }
}
