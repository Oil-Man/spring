package com.oilman.spring4.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 描述：任务计划执行类
 * Created by wangcw on 2019/4/10.
 */
@Service
public class SchedulerService {
    private SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void fixedRateTest(){
        System.out.println("每个五秒执行一次：" + format.format(new Date()));
        System.out.println(Thread.currentThread().getName());
    }

    @Scheduled(cron = "0 59 15 * * ?")
    public void cronTest(){
        System.out.println("定时执行：" + format.format(new Date()));
    }

}
