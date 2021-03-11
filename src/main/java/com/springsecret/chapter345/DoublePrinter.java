package com.springsecret.chapter345;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * DoublePrinter
 *
 * @author Alphonse
 * @version 1.0
 * @date 2021/3/5 10:51
 **/

@Component
@Order(3)
public class DoublePrinter implements Printer<Double> {
    @Override
    public void print(Double aDouble) {
        System.out.println("打印双精度浮点数：" + aDouble);
    }
}
