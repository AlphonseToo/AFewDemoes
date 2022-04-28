package com.zz.chaos.y2022;

import java.util.ArrayList;
import java.util.Iterator;

public class Demo0428 {

    private static final long TIME_TO_TEST = 5L * 1000L; // 10s

    public static StringBuilder fun() {
        StringBuilder sb = new StringBuilder();
        sb.append("add string");
        return sb;
    }

    public static String fun1() {
        StringBuilder sb = new StringBuilder();
        sb.append("add string");
        return sb.toString();
    }

    public static long fun2() {
        ArrayList<Integer> l = new ArrayList<Integer>(1000);
        for (int i = 0; i < 1000; ++i) {
            l.add(i);
        }
        long r = 0;
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < TIME_TO_TEST) {
            Iterator<Integer> it = l.iterator();
            r += it.next().longValue();
            r += it.next().longValue();
            r += it.next().longValue();
            r += it.next().longValue();
        }
        return r;
    }

    public static void fun3() {
        Object object = new Object();
        synchronized (object) {
            System.out.println();
        }
    }

    public static long fun4() {
        ArrayList<Integer> l = new ArrayList<Integer>(1000);
        for (int i = 0; i < 1000; ++i) {
            l.add(i);
        }
        long r = 0;
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < TIME_TO_TEST) {
            Iterator<Integer> it = l.iterator();
            for (int i = 0; i < l.size(); ++i) {
                r += it.next().longValue();
            }
        }
        return r;
    }

    // -XX:CompileThreshold 循环次数阈值
    public static void main(String[] args) {
        System.out.println("fun");
        fun();
        System.out.println("fun1");
        fun1();
        System.out.println("fun2");
        fun2();
        System.out.println("fun3");
        fun3();
        System.out.println("fun4");
        fun4();
    }
}
