package com.oilman.springmvc4;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

/**
 * 描述：Web配置，Servlet3.0+用于替代web.xml
 * Created by wangcw on 2019/4/11.
 */
public class WebInitializer implements WebApplicationInitializer{
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(MvcConfiguration.class);
        context.setServletContext(servletContext);
        Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
        servlet.addMapping("/"); //所有请求都会进入servlet（后期需要在mvc配置中过滤静态资源）
        servlet.setLoadOnStartup(1);
        servlet.setAsyncSupported(true); //开启servlet异步支持
    }
}
