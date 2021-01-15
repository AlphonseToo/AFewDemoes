package com.thinking.demo.chapter15;

/**
 * ****
 *
 * @author Alphonse
 * @date 2019/11/18 10:51
 * @since 1.0
 **/
public class E2<T> {
    public T a, b, c;

    public E2(T a, T b, T c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static void main(String[] args) {
        E2<String> e2 = new E2<>("AA", "BB", "CC");
        System.out.println(e2.getA());
    }
    public T getA() {
        return a;
    }

    public T getB() {
        return b;
    }

    public T getC() {
        return c;
    }

    public void setA(T a) {
        this.a = a;
    }

    public void setB(T b) {
        this.b = b;
    }

    public void setC(T c) {
        this.c = c;
    }
}
