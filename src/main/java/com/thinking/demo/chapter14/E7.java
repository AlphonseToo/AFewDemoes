package com.thinking.demo.chapter14;

/**
 * ****
 *
 * @author Alphonse
 * @date 2019/11/13 11:46
 * @since 1.0
 **/

class Candy{
    static {
        System.out.println("Loading Candy");
    }
}
class Gum{
    static {
        System.out.println("Loading Gum");
    }
}
class Cookie{
    static {
        System.out.println("Loading Cookie");
    }
}
public class E7 {
    public static void main(String[] args) throws Exception {
        for(String arg : args)
            Class.forName("com.thing.demo.chapter14." + arg);
        Class a = Boolean.TYPE;
    }
}
