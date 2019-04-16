package com.oilman.spring4.thread;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 描述：测试类
 * Created by wangcw on 2019/4/10.
 */
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecutorConfiguration.class);
        AsyncTaskService service = context.getBean(AsyncTaskService.class);
        for (int i = 0; i < 10; i++) {
            service.executeAsyncTask(i);
            service.executeAsyncTasPlus(i);
        }
        context.close();
    }
}
