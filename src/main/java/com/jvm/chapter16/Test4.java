//package com.jvm.chapter16;

public class Test4 {
    public static int foo(boolean f, int in) {
        int v;
        if (f) {
            v = in;
        } else {
            v = (int) Math.sin(in);
        }
        if (v == in) {
            return 0;
        } else {
            return (int) Math.cos(v);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 500000; i++) {
            foo(true, 2);
        }
        Thread.sleep(2000);
    }
}
