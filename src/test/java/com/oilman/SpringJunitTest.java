package com.oilman;

import com.oilman.spring4.profile.DBProperties;
import com.oilman.spring4.profile.ProfileConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 描述：spring的junit测试
 * Created by wangcw on 2019/4/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ProfileConfiguration.class})
@ActiveProfiles("dev")
public class SpringJunitTest {
    @Autowired
    private DBProperties dbProperties;

    @Test
    public void test(){
        System.out.println(dbProperties.getName());
    }
}
