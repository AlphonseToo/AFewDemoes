package com.spring.in.action.chapter03.ambiguity;

import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/12/24 15:54
 * @since 1.0
 **/
@Component
public class Cake implements Dessert {
    @Override
    public void eat() {
        System.out.println("Cake");
    }
}
