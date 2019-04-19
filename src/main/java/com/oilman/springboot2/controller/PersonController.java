package com.oilman.springboot2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述：控制器类
 * Created by wangcw on 2019/4/19.
 */
@Controller
public class PersonController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
