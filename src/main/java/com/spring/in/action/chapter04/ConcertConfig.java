package com.spring.in.action.chapter04;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * ****
 *
 * @author Alphonse
 * @date 2019/12/30 09:40
 * @since 1.0
 **/

@Configuration
@EnableAspectJAutoProxy // 启用AspectJ自动代理
@ComponentScan
public class ConcertConfig {

    @Bean
    public Audience audience() {
        return  new Audience();
    }
}
