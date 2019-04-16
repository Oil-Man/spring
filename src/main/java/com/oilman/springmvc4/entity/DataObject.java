package com.oilman.springmvc4.entity;

/**
 * 描述：传递值对象
 * Created by wangcw on 2019/4/11.
 */
public class DataObject {
    private Long id;
    private String name;

    public DataObject() {
    }

    public DataObject(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
