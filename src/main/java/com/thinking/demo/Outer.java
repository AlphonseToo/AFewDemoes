package com.thinking.demo;

import com.thinking.demo.chapter7.Stem;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/10/24 14:56
 * @since 1.0
 **/
public class Outer {
    Stem stem = new Stem();

    Stem func(Stem m){
        m = new Stem();
        System.out.println(m.toString());
        return m;
    }

    public static void main(String[] args){
        Outer outer = new Outer();
        Stem s = outer.func(null);
        System.out.println(s);

        System.out.println(null instanceof Stem);
    }
}
