package com.thinking.demo.chapter7.example;

/**
 * ~~~~~~~~~
 *
 * @author Alphonse
 * @date 2019/10/25 11:27
 * @since 1.0
 **/
class A{
    public int i = print("initialize i", 1);
    public A() {
        System.out.println("Class A");
    }
    public int print(String s, int i){
        System.out.println(s);
        return i;
    }
}
class B extends A{
    public int j = print("initialize j", 2);
    public B() {
        System.out.println("Class B");
    }
    public static void main(String[] args) {
        System.out.println("start");
        B b = new B();
        System.out.println("end");
    }
}

class AA{
    public int i = print("initialize i", 1);
    static {
        System.out.println("Class A: static block1");
    }
    static int ii = printStatic("initialize ii");
    static {
        System.out.println("Class A: static block2");
    }
    public AA() {
        System.out.println("Class A");
    }
    public int print(String s, int i){
        System.out.println(s);
        return i;
    }
    static int printStatic(String s){
        System.out.println(s);
        return 99;
    }
}
class BB extends AA{
    public int j = print("initialize j", 2);
    static {
        System.out.println("Class B: static block1");
    }
    static int jj = printStatic("initialize jj");
    static {
        System.out.println("Class B: static block2");
    }
    public BB() {
        System.out.println("Class B");
    }
    public static void main(String[] args) {
        System.out.println("start");
        //BB bb = new BB();
        System.out.println("end");
    }
}

public class Inherit {
    public static void main(String[] args) {
        System.out.println("start");
        BB b = new BB();
        System.out.println("end");
    }
}
