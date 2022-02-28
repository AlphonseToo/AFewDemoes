package com.jvm.chapter8;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class FooTest {

    static final MethodHandle mh;
    static {
        try {
            MethodHandles.Lookup l = MethodHandles.lookup();
            mh = l.findVirtual(FooTest.class, "bar", MethodType.methodType(void.class, Object.class));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void bar(Object o) {
    }

    public static void main(String[] args) throws Throwable {
//        MethodHandles.Lookup l = MethodHandles.lookup();
//        MethodType t = MethodType.methodType(void.class, Object.class);
//        MethodHandle mh = l.findVirtual(FooTest.class, "bar", t);

        long sum = 0;
        FooTest fooTest = new FooTest();
        FooTest[] fooTests = new FooTest[100_000_000];
        for (int i = 0; i < 100_000_000; i++) {
            fooTests[i] = new FooTest();
        }
        Object o = new Object();
        System.out.println("Let's start.");
        long current = System.currentTimeMillis();
        for (int i = 1; i <= 2_000_000_000; i++) {
            if (i % 100_000_000 == 0) {
                long temp = System.currentTimeMillis();
                System.out.println(temp - current);
                sum += temp - current;
                current = temp;
            }
            mh.invokeExact(new FooTest(), new Object());
        }
        System.out.println("average is " + sum / 20);
        // 1009
        // 888
        // 724
        // 2913
        // 2891
        // 548
        // final
    }
}
