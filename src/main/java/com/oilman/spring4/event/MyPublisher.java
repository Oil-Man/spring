package com.oilman.spring4.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * 描述：事件发布类
 * Created by wangcw on 2019/4/10.
 */
@Component
public class MyPublisher {
    @Autowired
    private ApplicationContext applicationContext;

    public void publish(ApplicationEvent event){
        //发布事件后，spring会到容器中去找监听该事件的监听器，并调用其onApplicationEvent方法
        applicationContext.publishEvent(event);
    }
}
