package com.spring.in.action.chapter03.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * ****
 *
 * @author Alphonse
 * @date 2019/12/24 15:11
 * @since 1.0
 **/
@Configuration
public class DataSourceConfig {

    @Bean
    @Profile("dev")
    public String devData(){
        return "配置dev1";
    }

    @Bean
    @Profile("prod")
    public String prodData(){
        return "配置prod1";
    }


}
