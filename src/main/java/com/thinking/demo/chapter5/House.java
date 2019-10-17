package com.thinking.demo.chapter5;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/10/16 16:11
 * @since 1.0
 **/
public class House {
    Window w1 = new Window(1);
    House() {
        System.out.println("House()");
        w3 = new Window(33);
    }
    Window w2 = new Window(2);
    void f() {
        System.out.println("f()");
        System.gc();
    }
    Window w3= new Window(3);

    protected void finalize(){
        System.out.println("House cleanup!");
    }

    public static void main(String[] args) {
        House house = new House();
        house.f();
    }
}
