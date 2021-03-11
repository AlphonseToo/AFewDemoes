package com.springsecret.chapter345;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * IntegerPrinter
 *
 * @author Alphonse
 * @version 1.0
 * @date 2021/3/5 10:51
 **/

@Component
@Order(3)
public class IntegerPrinter implements Printer<Integer> {
    @Override
    public void print(Integer integer) {
        System.out.println("打印整型：" + integer);
    }
}
