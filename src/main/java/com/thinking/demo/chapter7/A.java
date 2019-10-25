package com.thinking.demo.chapter7;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/10/24 14:09
 * @since 1.0
 **/
public class A {
    public int name;
    public A() {
        System.out.println("Class A");
    }
    public A(int i) {
        name = 100;
        System.out.println("Class A: " + i);
    }

    public int print(String s, int i){
        System.out.println(s);
        return i;
    }
}
