package com.zyf.demo;

import java.text.DecimalFormat;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/12/20 16:08
 * @since 1.0
 **/
public class DecimalFormatDemo {
    public static void main(String[] args) {
        DecimalFormat format = new DecimalFormat("####");
        long num = 1234;
        int ii = 123;
        double dd = 123.50;
        System.out.println(format.format(dd));
    }
}
