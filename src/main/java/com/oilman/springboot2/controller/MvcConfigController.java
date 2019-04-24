package com.oilman.springboot2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 描述：测试MvcConfig控制器
 * Created by wangcw on 2019/4/23.
 */
@Controller
public class MvcConfigController {
    @RequestMapping("/500")
    public ModelAndView to500(){
        ModelAndView modelAndView = new ModelAndView("error/500");
        if ( 1==1) throw new IllegalArgumentException("参数异常");
        modelAndView.addObject("msg", "成功");
        return modelAndView;
    }
}
