package com.oilman.spring4.profile;

/**
 * 描述：配置bean
 * Created by wangcw on 2019/4/9.
 */
public class DBProperties {
    private String name;

    public DBProperties(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
