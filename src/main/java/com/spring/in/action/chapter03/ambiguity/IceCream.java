package com.spring.in.action.chapter03.ambiguity;

import org.springframework.stereotype.Component;

/**
 * ****
 *
 * @author Alphonse
 * @date 2019/12/24 15:56
 * @since 1.0
 **/
@Component
@Cold
@Cool
public class IceCream implements Dessert {
    @Override
    public void eat() {
        System.out.println("IceCream");
    }
}
