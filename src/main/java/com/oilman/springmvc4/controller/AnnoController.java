package com.oilman.springmvc4.controller;

import com.oilman.springmvc4.entity.DataObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 描述：MVC常用注解演示控制器
 * Created by wangcw on 2019/4/11.
 */
@RestController
@RequestMapping("/anno")
public class AnnoController {
    @RequestMapping(produces = "text/plain;charset=UTF-8")
    public String index(HttpServletRequest request){
        return "url:"+request.getRequestURL()+" can access";
    }

    @RequestMapping("/data")
    public DataObject data(){
        return new DataObject(10L, "java");
    }

    @RequestMapping("/pathvar/{str}")
    public String pathvar(@PathVariable String str){
        return str;
    }

    @RequestMapping(value = "/obj", produces = "application/json")
    public Object obj(DataObject object){
        return object;
    }
}
