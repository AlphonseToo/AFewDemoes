package com.thinking.demo.chapter7.example;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/10/25 13:41
 * @since 1.0
 **/

class Cry{
    void fc1(){
        System.out.println("Cry.fc1()");
        fc2();
    }
    void fc2(){
        System.out.println("Cry.fc2()");
    }
}
class Dp extends Cry {
    void fc2(){
        System.out.println("Dp.fc2()");
    }
}
public class DiS {
    public static void main(String[] args){
        Dp dp = new Dp();
        dp.fc1();
    }
}
