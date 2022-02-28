package com.zz.chaos.y2022;

import java.lang.reflect.Method;

public class Demo0224 {

    private String ff(int i) {
        System.out.println(i);
        return "" + i;
    }

    public static void main(String[] args) throws Exception {
        Class clazz = Demo0224.class;
        Method ff = clazz.getMethod("ff", int.class);
        ff.invoke(null, 1);
    }
}
