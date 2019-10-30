package com.thinking.demo.chapter5;

/**
 * ~~~~~~~~
 *
 * @author Alphonse
 * @date 2019/10/16 19:08
 * @since 1.0
 **/

class Bowl{
    Bowl(int maker){
        System.out.println("Bowl(" + maker + ")");
    }
    void f1(int maker){
        System.out.println("f1(" + maker + ")");
    }
}

class Table{
    static Bowl bowl1 = new Bowl(1);
    Table() {
        System.out.println("Table()");
        bowl2.f1(1);
    }
    void f2(int maker) {
        System.out.println("f2(" + maker + ")");
    }
    static Bowl bowl2 = new Bowl(2);
}

class Cupboard{
    Bowl bowl3 = new Bowl(3);
    static Bowl bowl4 = new Bowl(4);
    Cupboard() {
        System.out.println("Cupboard()");
        bowl4.f1(2);
    }
    void f3(int maker){
        System.out.println("f3(" + maker + ")");
    }
    static Bowl bowl5 = new Bowl(5);
}

public class StaticInitialization {
    public static void main(String[] args){
        System.out.println("Creating new Cupboard() in main.");
        new Cupboard();
        System.out.println("Creating new Cupboard() in main.");
        new Cupboard();
        table.f2(1);
        cupboard.f3(1);
    }
    static Table table = new Table();
    static Cupboard cupboard = new Cupboard();
}

class Flower{
    int petalCount = 0;
    String s = "initial value";
    Flower(){
        this("hi", 47); //放在首行
        System.out.println("default constructor (no args)");
    }
    Flower(int petals){
        petalCount = petals;
        System.out.println("Constructor with int arg only, petalCount= " + petalCount);
    }
    Flower(String s, int petals){
        this(petals); //放在首行
        //this(1); //不能连续两次调用
        this.s = s;
        System.out.println("String & int args");
    }
    public static void main(String[] args){
        Flower x = new Flower();
    }
}