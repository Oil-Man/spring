package com.oilman.spring4.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 描述：需被注入到其他bean中的属性bean
 * Created by wangcw on 2019/4/8.
 */
@Service
public class DemoService {
    @Value("被注入其他类的属性") //直接注入普通字符串
    private String another;

    public String getAnother() {
        return another;
    }

    public void setAnother(String another) {
        this.another = another;
    }
}
