package com.jvm.chapter18;

public class Test {

    public static int foo(int i, int j) {
        return ((i+4)-3)*2/1 + j;
    }

    public int neg(int i) {
        return i+10240002;
    }

    public int fun(int i) {
        return neg(neg(i));
    }

    public void foo(long l, float f) {
        {
            int i = 0;
        }
        {
            String s = "Hello JVM.";
        }
    }
}
