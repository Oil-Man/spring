package com.oilman.spring4.aware;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 描述：自定义bean
 * Created by wangcw on 2019/4/10.
 */
@Component
public class MyBean implements BeanNameAware, ApplicationContextAware, ResourceLoaderAware {
    private String beanName;
    private ApplicationContext applicationContext;
    private ResourceLoader loader;

    @Override
    public void setBeanName(String s) {
        this.beanName = s;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.loader = resourceLoader;
    }

    public void print(){
        System.out.println(beanName);
        System.out.println(applicationContext.getBeanDefinitionCount());
        Resource resource = loader.getResource("aware/aware.txt");
        try {
            System.out.println(IOUtils.toString(resource.getInputStream(), "utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
