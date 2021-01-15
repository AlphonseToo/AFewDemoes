package com.spring.in.action.chapter03.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * ****
 *
 * @author Alphonse
 * @date 2019/12/24 15:06
 * @since 1.0
 **/
@Configuration
@Profile("prod")
public class ProductionProfileConfig {

    @Bean
    public String dataSource(){
        return "配置prod";
    }
}
