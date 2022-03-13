//package com.jvm.chapter16;
public class Test1 {

    public static void foo() {
        int sum = 0;
        for (int i = 0; i < 200; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        foo();
    }
}
