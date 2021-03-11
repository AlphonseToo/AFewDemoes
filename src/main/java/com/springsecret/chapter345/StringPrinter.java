package com.springsecret.chapter345;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * StringPrinter
 *
 * @author Alphonse
 * @version 1.0
 * @date 2021/3/5 10:49
 **/

@Component()
@Order(1)
public class StringPrinter implements Printer<String> {

    @Override
    public void print(String s) {
        System.out.println("打印字符串：" + s);
    }
}
