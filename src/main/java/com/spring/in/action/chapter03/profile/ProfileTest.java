package com.spring.in.action.chapter03.profile;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/12/24 15:16
 * @since 1.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ProfileTestConfig.class)
@ActiveProfiles({"prod", "dev"})
public class ProfileTest {
    @Autowired
    private DevelopmentProfileConfig config;
    @Autowired
    private ProductionProfileConfig config1;
    @Autowired
    private DataSourceConfig config2;

    @Test
    public void test1(){
        System.out.println(config.dataSource());
        System.out.println(config1.dataSource());
        // 此处输出结果为：配置prod配置prod
        // 因为dev和prod的方法名是一样的，在注册bean的时候是根据方法名来注册的
        // 所以，后面的bean覆盖了前面的bean
        System.out.println(config2.devData());
        System.out.println(config2.prodData());
    }
}
