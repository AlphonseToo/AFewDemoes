package com.jvm.chapter9;

import java.lang.invoke.MethodHandles;

public class Horse {
    public void race() {
        System.out.println("Horse.race()");
    }
    public static MethodHandles.Lookup lookup() {
        return MethodHandles.lookup();
    }
}
