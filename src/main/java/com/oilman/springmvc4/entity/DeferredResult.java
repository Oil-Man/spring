package com.oilman.springmvc4.entity;

/**
 * 描述：异步返回结果bean
 * Created by wangcw on 2019/4/15.
 */
public class DeferredResult<T> {
    private T result;

    public DeferredResult(){}

    public DeferredResult(T t){
        this.result = t;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
