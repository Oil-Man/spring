package com.oilman.springmvc4;

import com.oilman.springmvc4.converter.MyHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;
import java.util.List;

/**
 * 描述：mvc配置类 继承 WebMvcConfigurerAdapter（可以选择需要的方法实现） 进行定制化配置
 * Created by wangcw on 2019/4/11.
 */
@Configuration
@EnableWebMvc //开启一些mvc的默认配置
@ComponentScan("com.oilman.springmvc4")
@EnableScheduling
@EnableAsync
public class MvcConfiguration extends WebMvcConfigurerAdapter{

    //配置视图解析器
    @Bean
    public InternalResourceViewResolver viewResolver(){
        System.out.println("配置视图解析器");
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/classes/views/"); //这个配置的是打包后部署目录，非源码目录
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    //配置多媒体解析器
    @Bean
    public MultipartResolver multipartResolver(){
        System.out.println("配置多媒体解析器");
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setDefaultEncoding("UTF-8");
        multipartResolver.setMaxUploadSize(1024 * 100);
        return multipartResolver;
    }

    //静态资源配置 /static/** 对外暴露的路径，目录为类路径下的static文件夹
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println("配置静态路径");
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    //拦截器配置，静态资源不会进入拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("配置拦截器");
        HandlerInterceptor interceptor = new HandlerInterceptor() { //匿名实现类
            @Override
            public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
                if (httpServletRequest.getRequestURL().indexOf("/obj") > -1) {
                    long startTime = System.currentTimeMillis();
                    httpServletRequest.setAttribute("start", startTime);
                }
                return true;
            }

            @Override
            public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
                if (httpServletRequest.getRequestURL().indexOf("/obj") > -1) {
                    long startTime = (long) httpServletRequest.getAttribute("start");
                    System.out.println("请求时间：" + (System.currentTimeMillis() - startTime) + "ms");
                }
            }

            @Override
            public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
                if (httpServletRequest.getRequestURL().indexOf("/obj") > -1) {
                    System.out.println("拦截完成");
                }
            }
        };

        registry.addInterceptor(interceptor);
    }

    //配置消息转化器，configureMessageConverters重载会覆盖SpringMVC默认注册的消息转化器
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        System.out.println("配置消息转化器");
        //JSON消息转化器
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        jsonConverter.setDefaultCharset(Charset.forName("UTF-8"));
        converters.add(jsonConverter);
        jsonConverter.setJsonPrefix("Jackson");

        //String消息转化器
        StringHttpMessageConverter stringConverter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        converters.add(stringConverter);
    }

    //配置消息转化器，extendMessageConverters重载不会覆盖SpringMVC默认注册的消息转化器
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        //注册自定义HTTP消息转化器
        System.out.println("配置自定义消息转化器");
        converters.add(new MyHttpMessageConverter());
    }

    //配置页面重定向和页面视图控制器（无任何业务逻辑时使用）
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        System.out.println("配置页面重定向和页面视图控制器");
        registry.addRedirectViewController("/", "/hello");
        registry.addViewController("/toUpload").setViewName("/fileUpload");
        registry.addViewController("/converter").setViewName("/converter");
        registry.addViewController("/async").setViewName("/async");
    }

    //配置路径匹配参数设置
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        System.out.println("配置路径匹配参数设置");
        configurer.setUseSuffixPatternMatch(false); //配置不忽略“.”后面的参数
    }

}
