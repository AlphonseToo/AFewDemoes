package com.thinking.demo.chapter14;

/**
 * E1/E2
 *
 * @author Alphonse
 * @date 2019/11/13 11:17
 * @since 1.0
 **/

interface HasBatteries {}
interface Waterproof {}
interface Shoots {}
interface Fire{}

class Toy {
    //Toy(){}
    //Toy(int i){}
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots, Fire {
    FancyToy() {super();}
}
public class E1 {
    static void printInfo(Class cc) {

    }

    public static void main(String[] args) {
        try{
            Class c = Class.forName("com.thinking.demo.chapter14.FancyToy");
            for(Class face : c.getInterfaces()) {
                System.out.println(face.getCanonicalName());
            }
            Class up = c.getSuperclass();
            Object obj = up.newInstance();
        }catch (ClassNotFoundException e) {
            System.out.println("找不到类FancyToy");
        }catch (Exception e) {
            System.out.println("异常: " + e);
        }
    }
}
