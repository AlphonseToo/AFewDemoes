package com.thinking.demo.chapter15;

import java.util.ArrayList;

/**
 * 泛型的擦除
 *
 * @author Alphonse
 * @date 2019/11/22 10:20
 * @since 1.0
 **/
public class T6 {
    public static void main(String[] args) {
        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
        System.out.println(c1 == c2);
    }
}
class HasF{
    public void f() {
        System.out.println("HasF.f()");
    }
}
class Manipulator<T>{
    private T obj;
    public Manipulator(T x) { obj = x; }
    // Error: cannot resolve method f()
    //public void manipulate() { obj.f(); }
    public T[] genArray() {
        return (T[]) new Object[5];
    }
}
class Manipulation {
    public static void main(String[] args) {
        HasF hf = new HasF();
        Manipulator<HasF> manipulator = new Manipulator<>(hf);
        //manipulator.manipulate();
    }
}