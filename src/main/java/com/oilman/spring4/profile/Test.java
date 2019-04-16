package com.oilman.spring4.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 描述：测试类
 * Created by wangcw on 2019/4/9.
 * 方法一：context.getEnvironment().setActiveProfiles("dev");
 * 方法二：设置JVM启动参数 -Dspring.profiles.active=prod
 * 方法三：web应用可以在servlet中配置或者继承WebApplicationInitializer
 */
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProfileConfiguration.class);
        context.getEnvironment().setActiveProfiles("dev");
        context.register(ProfileConfiguration.class);
        context.refresh();

        System.out.println(context.getBean(DBProperties.class).getName());
        context.close();
    }
}
