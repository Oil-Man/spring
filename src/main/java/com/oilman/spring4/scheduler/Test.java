package com.oilman.spring4.scheduler;

import com.oilman.spring4.profile.DBProperties;
import com.oilman.spring4.profile.ProfileConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 描述：测试类
 * Created by wangcw on 2019/4/10.
 */
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SchedulerConfiguration.class);
        System.out.println(Thread.currentThread().getName());
    }
}
