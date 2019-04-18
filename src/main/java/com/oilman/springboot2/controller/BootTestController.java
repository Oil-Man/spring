package com.oilman.springboot2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：boot测试控制器
 * Created by wangcw on 2019/4/18.
 * 方式一、@PropertySource 和 @Value 配合使用可以实现属性注入
 * 方式二、@PropertySource 和 @ConfigurationProperties 前缀匹配类型安全属性注入，这个必须提供setter方法
 * 注：使用默认application.properties，则可以省略@PropertySource
 */
@RestController
@PropertySource({"classpath:other.properties"})
@ConfigurationProperties(prefix = "other.author")
public class BootTestController {
    @Value("${application.name}")
    private String applicationName;
    @Value("${other.name}")
    private String otherName;
    @Autowired
    private Environment environment;

    private String name;
    private String email;

    @RequestMapping("boot")
    public String testBoot(){
        return "Hello Spring Boot!";
    }

    @RequestMapping("properties")
    public String getProperties(){
        return applicationName + " " + otherName + " " + environment.getProperty("server.port");
    }

    @RequestMapping("config-properties")
    public String getConfigProperties(){
        return name + " " + email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
