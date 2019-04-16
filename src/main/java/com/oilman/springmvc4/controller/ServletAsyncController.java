package com.oilman.springmvc4.controller;

import com.oilman.springmvc4.entity.DeferredResult;
import com.oilman.springmvc4.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 描述：Servlet异步处理控制器
 * Created by wangcw on 2019/4/15.
 */
@Controller
public class ServletAsyncController {

    @Autowired
    private PushService pushService;

    @RequestMapping("defer")
    @ResponseBody
    public DeferredResult<String> deferredCall(){
        return pushService.getAsyncUpdate();
    }

}
