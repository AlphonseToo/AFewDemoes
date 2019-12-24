package com.spring.in.action.chapter03.ambiguity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/12/24 15:57
 * @since 1.0
 **/
@Configuration
@ComponentScan
public class Kid {
    private Dessert dessert;
    @Autowired
    @Cold
    @Warm
    public void setDessert(Dessert dessert) {
        this.dessert = dessert;
    }

    @Override
    public String toString() {
        dessert.eat();
        return super.toString();
    }
}
