package com.jvm.chapter14;

public class SynchronizedTest {
    static Lock lock = new Lock();
    static int counter = 0;

    public static void foo() {
        synchronized (lock) {
            counter++;
        }
    }

    public static void main(String[] args) {
          lock.hashCode(); // step2
        System.identityHashCode(lock); // step4
        for (int i = 0; i < 1_000_000; i++) {
            foo();
        }
    }


    static class Lock {
         @Override public int hashCode() { return 0; } // Step 3
    }
}
