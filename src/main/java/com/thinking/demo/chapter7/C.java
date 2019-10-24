package com.thinking.demo.chapter7;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/10/24 14:09
 * @since 1.0
 **/
public class C extends A {
    private B b;
    public int name;
    public C(int i) {
        super(i);
        b = new B();
        name = 999;
        System.out.println("Class C");
    }

    public static void main(String[] args) {
        C c = new C(1);
        System.out.println(c.name);
        System.out.println(c.b);

    }
}
