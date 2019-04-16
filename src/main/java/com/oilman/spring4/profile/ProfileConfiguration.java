package com.oilman.spring4.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * 描述：环境配置
 * Created by wangcw on 2019/4/9.
 */
@Configuration
public class ProfileConfiguration {
    @Bean
    @Profile("dev")
    public DBProperties devProperties(){
        return new DBProperties("开发环境");
    }

    @Bean
    @Profile("prod")
    public DBProperties prodProperties(){
        return new DBProperties("生产环境");
    }
}
