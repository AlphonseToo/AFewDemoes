package com.spring.in.action.chapter03.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/12/24 15:06
 * @since 1.0
 **/
@Configuration
@Profile("dev")
public class DevelopmentProfileConfig {

    @Bean
    public String dataSource(){
        return "配置dev";
    }
}
