package com.example.demo.condiitionalOnMissingBean.config;

import com.example.demo.condiitionalOnMissingBean.bean.Computer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: BeanConfig
 * @Description: TODO
 * @Author: Alphonse
 * @Version: 1.0
 * @Date: 2019/10/12 13:59
 **/
@Configuration
public class BeanConfig {
    @Bean("notebook")
    public Computer computer1() {
        return new Computer("笔记本");
    }

    //@ConditionalOnMissingBean(Computer.class)
    @ConditionalOnBean(Computer.class)
    @Bean("beiyong")
    public Computer computer2() {
        return new Computer("备用电脑");
    }
}
