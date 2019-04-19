package com.oilman.springboot2.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;

/**
 * 描述：错误页面跳转配置
 * Created by wangcw on 2019/4/19.
 */
@SpringBootConfiguration
public class ErrorPageConfiguration implements ErrorPageRegistrar{
    @Override
    public void registerErrorPages(ErrorPageRegistry errorPageRegistry) {
        ErrorPage error400Page = new ErrorPage(HttpStatus.NOT_FOUND, "/400");
        errorPageRegistry.addErrorPages(error400Page);
    }
}
