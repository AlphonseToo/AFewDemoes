package com.zz.chaos.y2022;

import java.lang.reflect.Method;

public class Demo0222 {
    private int tryBlock;
    private int catchBlock;
    private int finallyBlock;
    private int methodExit;

    public void test() {
        try {
            tryBlock = 0;
        } catch (Exception e) {
            catchBlock = 1;
        } finally {
            finallyBlock = 2;
            System.out.println("2");
            System.out.println(1/0);
        }
        methodExit = 3;
    }

    public static void main(String[] args) throws Exception {
        Demo0222 demo0222 = new Demo0222();
        demo0222.test();
        Method method = Demo0222.class.getMethod("test");
    }
}
