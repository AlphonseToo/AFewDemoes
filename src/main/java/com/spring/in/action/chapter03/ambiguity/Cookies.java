package com.spring.in.action.chapter03.ambiguity;

import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/12/24 15:56
 * @since 1.0
 **/
@Component
@Cold
@Warm
public class Cookies implements Dessert {

    @Override
    public void eat() {
        System.out.println("Cookies");
    }

}
