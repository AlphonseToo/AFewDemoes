package com.thinking.demo.chapter14;

import java.util.Arrays;
import java.util.List;

/**
 * E3/E4/E5
 *
 * @author Alphonse
 * @date 2019/11/13 11:30
 * @since 1.0
 **/

abstract class Shape {
    int area = 100;
    void draw() {
        System.out.println(this + ".draw()");
    }
    void rotate(){
        if (this instanceof Circle) {
            System.out.println(this + " is unnecessary");
        }else {
            System.out.println(this + ".rotate");
        }
    }

    void markAllShapes() {

    }
    abstract public String toString();
}

class Circle extends Shape {
    @Override
    public String toString() {
        return "Circle";
    }
}
class Square extends Shape {
    @Override
    public String toString() {
        return "Square";
    }
}
class Triangle extends Shape {
    @Override
    public String toString() {
        return "Triangle";
    }
}
class Rhomboid extends Shape {
    @Override
    public String toString() {
        return "Rhomboid";
    }
}
public class E3 {
    public static void main(String[] args) {
        List<Shape> shapeList = Arrays.asList(new Circle(), new Square(), new Triangle());
        for(Shape s : shapeList) {
            s.draw();
            s.rotate();
        }
        Shape shape = new Rhomboid();
        if(shape instanceof Circle)
            ((Circle)shape).draw();
        if(shape instanceof Rhomboid)
            ((Rhomboid)shape).draw();
    }
}
