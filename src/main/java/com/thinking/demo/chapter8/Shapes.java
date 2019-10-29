package com.thinking.demo.chapter8;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/10/24 17:48
 * @since 1.0
 **/
public class Shapes {
    private static ShapeRandomGen gen = new ShapeRandomGen();
    public static void main(String[] args) {
        Shape[] s = new Shape[5];
        for (int i = 0; i < 5; i++) {
            s[i] = gen.next();
        }
        Shape shape = new Circle();
        shape.draw();
        /*for (Shape shape : s) {
            shape.pp();
        }*/
    }
}
