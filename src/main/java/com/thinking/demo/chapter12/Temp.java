package com.thinking.demo.chapter12;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/11/7 17:03
 * @since 1.0
 **/
class Casd {
    public Casd() {
        System.out.println("Here");
    }
    public Casd(String s) {
        System.out.println("Here" + s);
    }
}
public class Temp extends Casd {
    public Temp(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        Temp temp = new Temp("haha");
    }
}
