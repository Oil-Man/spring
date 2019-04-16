package com.oilman.spring4.spel;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

/**
 * 描述：EL表达式配置类
 * Created by wangcw on 2019/4/8.
 */
@Configuration
@ComponentScan("com.oilman.spring4.spel")
@PropertySource({"classpath:spel/el.properties"})
public class ElConfiguration {
    @Value("normal string")
    private String normal; //注入字符串
    @Value("#{systemProperties['os.name']}")
    private String osName; //注入操作系统属性，使用#{}
    @Value("#{T(java.lang.Math).random() * 100.0}")
    private double randomNumber; //注入表达式结果，使用#{}
    @Value("#{demoService.another}")
    private String fromAnother; //注入其他bean属性，使用#{}
    @Value("classpath:spel/el.txt")
    private Resource testFile; //注入文件资源
    @Value("http://www.baidu.com")
    private Resource testUrl; //注入网络资源
    @Value("${book.name}")
    private String bookName; //注入配置文件，使用${}

    @Autowired
    private Environment environment; //spring会将配置文件内容保存到Environment中

    public void printResource(){
        try {
            System.out.println(normal);
            System.out.println(osName);
            System.out.println(randomNumber);
            System.out.println(fromAnother);
            System.out.println(IOUtils.toString(testFile.getInputStream(), "utf-8"));
            System.out.println(IOUtils.toString(testUrl.getInputStream(), "utf-8"));
            System.out.println(bookName);
            System.out.println(environment.getProperty("book.author"));
        }catch (Exception e){}

    }
}
