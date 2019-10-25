package com.thinking.demo.chapter8;

import java.util.Random;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/10/24 17:45
 * @since 1.0
 **/
public class ShapeRandomGen {
    private Random random = new Random(898);

    public Shape next(){
        switch (random.nextInt(3)) {
            default:
            case 0: return new Circle();
            case 1: return new Square();
            case 2: return new Triangle();
        }
    }
}
