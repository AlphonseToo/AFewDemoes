package com.thinking.demo.chapter9;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/10/28 18:04
 * @since 1.0
 **/

abstract class C51{
    public void play(){
        System.out.println("play");
    }
    public void what(){
        System.out.println("sdq");
    }
}

class C52 extends C51{
    @Override
    public void what() {
        System.out.println("what");
    }
}
public class E5{
    public static void main(String[] args){
        C52 c52 = new C52();
        c52.what();
        //C51 c51 = new C51();
    }
}
