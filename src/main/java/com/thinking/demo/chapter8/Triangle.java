package com.thinking.demo.chapter8;

/**
 * ~~~~~
 *
 * @author Alphonse
 * @date 2019/10/24 17:44
 * @since 1.0
 **/
public class Triangle extends Shape {
    public void draw(){
        System.out.println("Triangle.draw()");
    }
    @Override
    public void erase(){
        System.out.println("Triangle.erase()");
    }

    @Override
    public void pp() {
        System.out.println("Triangle test");
    }
}
