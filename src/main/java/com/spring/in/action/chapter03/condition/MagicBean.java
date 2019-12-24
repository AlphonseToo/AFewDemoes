package com.spring.in.action.chapter03.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/12/24 15:41
 * @since 1.0
 **/
public class MagicBean {

    @Bean
    @Conditional(MagicExistsCondition.class)
    public MagicBean magicBean() {
        return new MagicBean();
    }
}
