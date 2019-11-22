package com.thinking.demo.chapter17;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/11/22 09:34
 * @since 1.0
 **/
class Qmp{
    public static final  <T> void fun(T t){
        System.out.println("sdsa");
    }
}
public class T3 extends Qmp{
    public static void fun(){

        System.out.println("aaaaaaaa");
    }

    public static void main(String[] args) {
        Qmp.fun(null);
    }
}
