package com;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * B
 *
 * @author Alphonse
 * @version 1.0
 * @date 2021/1/13 15:56
 **/
@Component
public class B extends A {

    @Override
    protected void functionB() {
        System.out.println("方法BB");
    }

    protected void functionC() {
        System.out.println("方法CC");
    }


    public static void main(String[] args) {
        B b = new B();
        b.functionA();
        System.out.println(b.b);

        BigDecimal a = new BigDecimal(12);
        BigDecimal bb = new BigDecimal(13);
        a = a.add(bb);
        System.out.println(a);
    }
}
