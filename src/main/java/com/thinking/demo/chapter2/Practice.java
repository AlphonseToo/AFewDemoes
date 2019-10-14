package com.thinking.demo.chapter2;

import java.util.Random;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/10/14 15:28
 * @since 1.0
 **/
public class Practice {
    private double s, t, v;
    private int a, b;
    private static Random random = new Random();
    public static void main(String [] args) {
        Practice practice = new Practice();
        Practice practice1 = new Practice();
        System.out.println(practice.toString());
        System.out.println(practice1.toString());
        System.out.println(practice.equals(practice1));
        String coin = practice.a == 1 ? "tail" : "head";
        System.out.println("coin: " + coin + "    a:" + practice.a + "  b: " + practice.b);
    }

    public Practice() {
        init();
    }

    @Override
    public boolean equals(Object obj) {
        return this.v == ((Practice)obj).v;
    }

    private void init() {
        s = random.nextDouble();
        t = random.nextDouble();
        v = s/t;
        a = random.nextInt(2);
        b = 0x80000000;
    }
    //无用的注释
    //无用的注释。
    //无用的注释。。
    @Override
    public String toString() {
        return "Practice{" +
                "s=" + s +
                ", t=" + t +
                ", v=" + v +
                '}';
    }
    //2^32+1+a
}
