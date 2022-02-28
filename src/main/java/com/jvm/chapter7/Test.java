package com.jvm.chapter7;

import java.lang.reflect.Method;

public class Test {

    public static void target(int i) {
        // new Exception("#" + i).printStackTrace();
    }

    public static void main(String[] args) throws Exception {
        Class<?> test = Class.forName("com.jvm.chapter7.Test");
        Method method = test.getMethod("target", int.class);
        Method method1 = test.getMethod("target", int.class);
        Object[] arg = new Object[1]; // 在循环外构造参数数组
        arg[0] = 128;
//        run(method);
//        run(method1);
        // 0   371
        // 128 501 -- 触发了自动装箱
        // arg 478
        // // -Djava.lang.Integer.IntegerCache.high=128
        //// -Dsun.reflect.noInflation=true
        //
        System.out.println("method: " + method);
        System.out.println("method1: " + method1);
        System.out.println(method1);
        System.out.println(method == method1);
        System.out.println(method.equals(method1));

    }

    public static void run(Method method) throws Exception {
        long sum = 0;
        long l = System.currentTimeMillis();
        for (int i = 1; i <= 2_000_000_000; i++) {
            if (i % 100_000_000 == 0) {
                long temp = System.currentTimeMillis();
                long interval = temp - l;
//                System.out.println("A billion cost: " + interval);
                l = temp;
                sum += interval;
            }
            method.invoke(null, 128);
        }
        System.out.println("average is " + sum / 20);
    }
}
