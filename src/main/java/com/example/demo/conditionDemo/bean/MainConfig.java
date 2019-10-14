package com.example.demo.conditionDemo.bean;

import com.example.demo.conditionDemo.condition.MyCondition;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: MainConfig
 * @Description: TODO
 * @Author: Alphonse
 * @Version: 1.0
 * @Date: 2019/10/12 13:39
 **/
@Conditional({MyCondition.class})
@ConditionalOnBean
@Configuration
public class MainConfig {
    @Bean
    public User1 getUser1() {
        System.out.println("创建user实例1");
        return new User1("用户1",1);
    }

    @Bean
    public User1 getUser2() {
        System.out.println("创建user实例2");
        return new User1("用户2",2);
    }
}
