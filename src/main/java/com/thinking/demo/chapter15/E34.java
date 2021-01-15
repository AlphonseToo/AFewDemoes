package com.thinking.demo.chapter15;

/**
 * ****
 *
 * @author Alphonse
 * @date 2019/11/20 10:44
 * @since 1.0
 **/
abstract class Yuu<T extends Yuu<T>>{
    abstract T ab(T t);
    T normal(T t) {
        System.out.println("normal:" + t.toString());
        return ab(null);
    }
}

public class E34 extends Yuu<E34> {
    @Override
    E34 ab(E34 t) {
        if(t == null)
            return this;
        System.out.println("ab:" + t.toString());
        return t;
    }

    public static void main(String[] args) {
        E34 e34 = new E34();
        e34.normal(e34);
    }
}
