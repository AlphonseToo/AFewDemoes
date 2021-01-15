package com.spring.in.action.chapter04;

import org.springframework.context.annotation.ComponentScan;

/**
 * ****
 *
 * @author Alphonse
 * @date 2019/12/30 09:54
 * @since 1.0
 **/
@ComponentScan
public class Actor_1 implements Performance {
    @Override
    public void perform() {
        System.out.println("Actor1 starts");
    }

    public static void main(String[] args) {
        Actor_1 a1 = new Actor_1();
        a1.perform();
    }
}
