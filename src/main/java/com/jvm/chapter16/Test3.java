//package com.jvm.chapter16;

public class Test3 {

    public static int hash(Object obj) {
        if (obj instanceof Exception) {
            return System.identityHashCode(obj);
        } else {
            return obj.hashCode();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 500000; i++) {
            hash(i);
        }
        Thread.sleep(2000);
    }
}
