package com.spring.in.action.chapter05;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2020/1/7 14:59
 * @since 1.0
 **/
@Configuration
@ComponentScan(basePackages = {"com.spring.in.action.chapter05.web"},
    excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)})
public class RootConfig {

}
