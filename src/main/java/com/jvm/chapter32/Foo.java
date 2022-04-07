package com.jvm.chapter32;

public class Foo {
    public static native void foo();
    public native void bar(int i, long j);
    public native void bar(String s, Object o);
}
