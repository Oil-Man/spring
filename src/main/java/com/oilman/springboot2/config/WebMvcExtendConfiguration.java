package com.oilman.springboot2.config;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * 描述：扩展SpringBoot MVC自动配置
 * 方式一：继承WebMvcConfigurationSupport
 * 方式二：实现WebMvcConfigurer
 * 方式三：继承WebMvcConfigurerAdapter，不过这个在java8出现接口默认方法后已经被标记为deprecated
 * 注意事项：继承WebMvcConfigurationSupport会导致自动配置失效，需要手动加入静态资源的配置，
 *          因为自动配置的前提是容器中没有这个bean，具体参见WebMvcAutoConfiguration
 * Created by wangcw on 2019/4/19.
 */
@Configuration
public class WebMvcExtendConfiguration implements WebMvcConfigurer{

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //404错误跳转404.html
        registry.addViewController("/400").setViewName("/error/400");
        //webSocket快捷地址映射
        registry.addViewController("/ws").setViewName("/ws");
    }

    //springboot默认错误处理路径静态资源根目录下的error/错误码.html
    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        HandlerExceptionResolver resolver = (request, response, object, ex) -> {
            if (ex instanceof NullPointerException){
                ModelAndView modelAndView = new ModelAndView("/error/500");
                modelAndView.addObject("msg", ex.getMessage());
                return modelAndView;
            }
            return null;
        };
        resolvers.add(resolver);
    }

    /**
     * 描述：配置http转向https
     * @Param []
     * @Return org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
     */
    @Bean
    public TomcatServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint constraint = new SecurityConstraint();
                constraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/*");
                constraint.addCollection(collection);
                context.addConstraint(constraint);
            }
        };
        tomcat.addAdditionalTomcatConnectors(httpConnector());
        return tomcat;
    }

    @Bean
    public Connector httpConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setScheme("http");
        //Connector监听的http的端口号
        connector.setPort(8080);
        connector.setSecure(false);
        //监听到http的端口号后转向到的https的端口号
        connector.setRedirectPort(8081);
        return connector;
    }
}