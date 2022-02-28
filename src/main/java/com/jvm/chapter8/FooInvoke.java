package com.jvm.chapter8;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class FooInvoke {
    static final MethodHandle mh;
    static {
        try {
            MethodHandles.Lookup l = MethodHandles.lookup();
            MethodType t = MethodType.methodType(void.class, int.class);
            mh = l.findStatic(FooInvoke.class, "target", t);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static void target(int i) { }

    public static void main(String[] args) throws Throwable {
//        MethodHandles.Lookup l = MethodHandles.lookup();
//        MethodType t = MethodType.methodType(void.class, int.class);
//        MethodHandle mh = l.findStatic(FooInvoke.class, "target", t);

        long sum = 0;
        long current = System.currentTimeMillis();
        for (int i = 1; i <= 2_000_000_000; i++) {
            if (i % 100_000_000 == 0) {
                long temp = System.currentTimeMillis();
                System.out.println(temp - current);
                sum += temp - current;
                current = temp;
            }
            mh.invokeExact(128);
        }
        System.out.println("The average is " + sum/20);
        // 380
        // 103
    }
}
