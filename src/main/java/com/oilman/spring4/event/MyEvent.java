package com.oilman.spring4.event;

import org.springframework.context.ApplicationEvent;

/**
 * 描述：自定义事件
 * Created by wangcw on 2019/4/9.
 */
public class MyEvent extends ApplicationEvent{
    private String msg;

    public MyEvent(Object source, String msg) { //source 事件源
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
