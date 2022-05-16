package com.zz.chaos.y2022;

public class Demo0512 {
    private static ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set("123");
        Thread thread = new Thread(() -> System.out.println(threadLocal.get()));
        thread.start();
        Aaa aaa = new Aaa();

    }

    public interface Asd1{}
    public interface Asd2 {}
    public interface Asd3 extends Asd1, Asd2{}
    public static class Aaa implements Asd3 {

    }
}
