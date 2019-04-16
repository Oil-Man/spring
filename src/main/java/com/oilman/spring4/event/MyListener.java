package com.oilman.spring4.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 描述：事件监听器
 * Created by wangcw on 2019/4/10.
 */
@Component
public class MyListener implements ApplicationListener<MyEvent>{
    @Override
    public void onApplicationEvent(MyEvent myEvent) {
        System.out.println("监听器收到的消息：" + myEvent.getMsg());
        System.out.println("事件源：" + myEvent.getSource().getClass().getName());
    }
}
