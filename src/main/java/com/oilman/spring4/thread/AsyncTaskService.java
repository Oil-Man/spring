package com.oilman.spring4.thread;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 描述：任务执行类
 * Created by wangcw on 2019/4/10.
 */
@Service
public class AsyncTaskService {

    @Async
    public void executeAsyncTask(int i){
        System.out.println("执行异步任务：" + i);
    }

    @Async
    public void executeAsyncTasPlus(int i){
        System.out.println("执行异步任务+1：" + (i+1));
    }
}
