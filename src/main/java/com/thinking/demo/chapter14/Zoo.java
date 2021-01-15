package com.thinking.demo.chapter14;

/**
 * ****
 *
 * @author Alphonse
 * @date 2019/11/15 14:08
 * @since 1.0
 **/
public class Zoo {
    public static void main(String[] args) {
        Fruit fruit = new Apple();
        if (fruit instanceof Apple) {
            System.out.println(1);
        }
        Apple apple = (Apple) fruit;
        //Orange apple = (Orange) fruit;
    }
}
class Fruit{}
class Apple extends Fruit{}
class Orange {}
