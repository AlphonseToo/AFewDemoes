package com.jvm.chapter26;

public class VectorizationTest {

    static void foo(int[] a, int[] b, int[] c) {
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i] + b[i];
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int[] a = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4, 5, 6, 7, 8 };
        int[] c = new int[32];
        for (int i = 0; i < 20_000; i++) {
            foo(a, a, c);
        }
        Thread.sleep(2000);
    }
}
