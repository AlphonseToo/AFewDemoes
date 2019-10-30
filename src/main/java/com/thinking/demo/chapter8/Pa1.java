package com.thinking.demo.chapter8;

/**
 * ~~~~~~~~~
 *
 * @author Alphonse
 * @date 2019/10/24 20:18
 * @since 1.0
 **/

class Aa{
    void f1(){
        System.out.println("Aa.f1()");
        f2();
    }
    void f2(){
        System.out.println("Aa.f1()");
    }
}

class Bb extends Aa{

    void f2(){
        System.out.println("Bb.f2()");
    }
}

public class Pa1 {
    public static void main(String[] args){
        Bb bb = new Bb();
        bb.f1();
    }
}
