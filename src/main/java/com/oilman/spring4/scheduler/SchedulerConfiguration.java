package com.oilman.spring4.scheduler;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 描述：调度器配置
 * Created by wangcw on 2019/4/10.
 */
@ComponentScan("com.oilman.spring4.scheduler")
@Configuration
@EnableScheduling //开启任务调度
public class SchedulerConfiguration {
}
