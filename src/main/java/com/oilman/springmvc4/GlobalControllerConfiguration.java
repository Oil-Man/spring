package com.oilman.springmvc4;

import com.oilman.springmvc4.controller.AnnoController;
import com.oilman.springmvc4.controller.HelloController;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * 描述：全局控制器配置
 * Created by wangcw on 2019/4/12.
 * @ControllerAdvice 标注该类为全局控制器配置类，可以指定可作用于那些包/类/注解的控制器
 * 1.不指定具体作用范围时，默认对所有Controller都起作用
 * 2.当指定具体作用范围时，当前包及子包会被作用，所以如果仅需作用某一个Controller的话，应该把这个Controller放入
 * 最里层的包中，且不包含子包Controller及其他同包Controller
 */
@ControllerAdvice(basePackageClasses = {AnnoController.class})
//@ControllerAdvice("com.oilman.springmvc4.controller")
public class GlobalControllerConfiguration {
    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(Exception e, WebRequest request){
        ModelAndView modelAndView = new ModelAndView("error/500");
        modelAndView.addObject("errorMsg", e.getMessage());
        return modelAndView;
    }

    @ModelAttribute
    public void addAttribute(Model model){
        model.addAttribute("msg", "其他信息");
    }

    @InitBinder //定制WebDataBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("id"); //忽略request参数的id
    }

}
