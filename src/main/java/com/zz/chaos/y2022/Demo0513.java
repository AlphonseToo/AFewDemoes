package com.zz.chaos.y2022;

public class Demo0513 {

    private static Class<? extends C1> clazz;

    public static void main(String[] args) {
        clazz = C2.class;
        clazz = C1.class;
    }

    class C0 {}

    class C1 {

    }

    class C2 extends C1 {

    }

    class ClassLoaders extends ClassLoader {

    }
}
