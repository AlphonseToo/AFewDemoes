package com.thinking.demo.chapter14;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ****
 *
 * @author Alphonse
 * @date 2019/11/13 14:18
 * @since 1.0
 **/

class HShape{
    boolean mark = false;
    public void highlight(){mark = true;}
    public void clearHighlight() {mark = false;}
    void draw() {
        System.out.println(this + " draw()");
    }
    public String toString(){
        return getClass().getName() + (mark ? " highlighted" : " normal");
    }
    public static List<HShape> shapes = new ArrayList<>();

    HShape() {
        shapes.add(this);
    }
    static void highlight1(Class<?> type) {
        for(HShape shape : shapes) {
            if(type.isInstance(shape))
                shape.highlight();
        }
    }
    static void clearHighlight1(Class<?> type) {
        for(HShape shape : shapes) {
            if(type.isInstance(shape))
                shape.clearHighlight();
        }
    }
    static void forEach(Class<?> type, String method) {
        try {
            Method m = HShape.class.getMethod(method, (Class<?>[])null);
            for(HShape shape : shapes) {
                if(type.isInstance(shape))
                    m.invoke(shape, (Object[])null);
            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    static void highlight2(Class<?> type) {
        forEach(type, "highlight");
    }
    static void clearHighlight2(Class<?> type) {
        forEach(type, "clearHighlight");
    }
}
class HCircle extends HShape{}
class HSquare extends HShape{}
class HTriangle extends HShape{}
public class E6 {
    public static void main(String[] args) {
        List<HShape> list = Arrays.asList(new HCircle(), new HSquare(), new HTriangle());
        HShape.highlight1(HCircle.class);
        //HShape.highlight2(HCircle.class);
        for (HShape shape : list) {
            shape.draw();
        }
        System.out.println("***************");
        HShape.highlight1(HShape.class);
        for (HShape shape : list) {
            shape.draw();
        }
        System.out.println("****************");
        HShape.clearHighlight1(ArrayList.class);
        for (HShape shape : list) {
            shape.draw();
        }
    }
}
