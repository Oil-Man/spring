package com.oilman.spring4.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * 描述：配置类
 * Created by wangcw on 2019/4/8.
 */
@Configuration
//@ComponentScan("com.oilman.spring4.ioc")
public class SpringIocConfiguration {
    @Bean
    //@Scope("prototype")
    public FunctionService functionService(){
        return new FunctionService();
    }

    @Bean
    public UseFunctionService useFunctionService(){
        UseFunctionService useFunctionService = new UseFunctionService();
        useFunctionService.setFunctionService(functionService());
        return useFunctionService;
    }
}
