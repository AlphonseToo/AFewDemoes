package com.jvm;

public class Test {

    private static void loop() {
        long value = 0L;
        for(int j = 0; j < '1'; ++j) {
            for(int i = 0; i < 100000000; ++i) {
                ++value;
            }
        }

        System.out.println("Done " + value);
    }

    public static void main(String[] args) {
        loop();
        Class<Test> testClass = Test.class;
        ClassLoader classLoader = testClass.getClassLoader();
        System.out.println(classLoader);
        long start = System.currentTimeMillis();
        long end = System.currentTimeMillis();
        System.out.println("cost: " + (end - start));
    }

}
