package com.example.demo.conditionalOnClass.config;

import com.example.demo.conditionalOnClass.bean.AClass;
import com.example.demo.conditionalOnClass.bean.Asy;
import com.example.demo.conditionalOnClass.bean.BClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: TheConfig
 * @Description: TODO
 * @Author: Alphonse
 * @Version: 1.0
 * @Date: 2019/10/12 18:01
 **/
@Configuration()
@ConditionalOnClass({BClass.class})
public class TheConfig {
    @Bean("AClass")
    public Asy func1() {
        return new AClass();
    }

    @Bean("BClass")
    public Asy func2() {
        return new BClass();
    }
}
