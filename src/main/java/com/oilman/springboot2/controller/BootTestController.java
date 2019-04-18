package com.oilman.springboot2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：boot测试控制器
 * Created by wangcw on 2019/4/18.
 */
@RestController
public class BootTestController {
    @RequestMapping("boot")
    public String boot(){
        return "Hello Spring Boot!";
    }

}
