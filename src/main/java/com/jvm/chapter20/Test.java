package com.jvm.chapter20;

public class Test {

    private final static boolean flag = true;
    private final static int value0 = 0;
    private final static int value1 = 1;

    public static int foo(int value) {
        int result = bar(flag);
        if (result != 0) {
            return result;
        } else {
            return  value;
        }
    }

    public static int bar(boolean flag) {
        return flag ? value0 : value1;
    }
}
