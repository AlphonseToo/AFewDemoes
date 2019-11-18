package com.thinking.demo.chapter15;

/**
 * E9/10
 *
 * @author Alphonse
 * @date 2019/11/18 16:46
 * @since 1.0
 **/
class GenericMethods {
    public <T, U, V> void f(T t, U u, V v){
        System.out.println(t.getClass().getSimpleName() + " " + u.getClass().getSimpleName() + " " + v.getClass().getSimpleName());
    }
}
public class T3 {
    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f(1,2,3);
        gm.f(1.2, "ik", true);
    }
}
