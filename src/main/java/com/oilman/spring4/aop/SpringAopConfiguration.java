package com.oilman.spring4.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 描述：配置类
 * Created by wangcw on 2019/4/8.
 */
@Configuration
@ComponentScan("com.oilman.spring4.aop")
@EnableAspectJAutoProxy
public class SpringAopConfiguration {
}
