package com.thinking.demo.chapter2;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/10/16 10:30
 * @since 1.0
 **/
public class Dog {
    boolean empty = true;
    public void bark(int times, boolean bool) {
        empty = false;
        for (int i = 0; i < times; i++) {
            System.out.println("barking!");
        }
    }

    public void bark(String state, int i){
        empty = false;
        for (int j = 0; j < i; j++) {
            System.out.println("The dog is howling(" + state + ")!");
        }
    }

    protected void finalize() {
        if(empty)
            System.out.println("cleanup");
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.bark(4, true);
        dog.bark("angry", 2);
        dog.bark("angry", 2);
        dog.setEmpty(true);
        dog = null;
        new Dog().setEmpty(true);
        System.gc();
    }
}
