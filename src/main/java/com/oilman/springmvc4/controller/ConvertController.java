package com.oilman.springmvc4.controller;

import com.oilman.springmvc4.entity.DataObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 描述：自定义消息转化器控制器
 * Created by wangcw on 2019/4/15.
 */
@Controller
public class ConvertController {

    @RequestMapping(value = "/convert", produces = "application/x-dataObject")
    @ResponseBody
    public DataObject convert(@RequestBody String object){
        System.out.println("ConvertController.convert");
        return new DataObject();
    }
}
