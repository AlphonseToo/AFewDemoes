package com.thinking.demo.chapter7;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/10/24 14:25
 * @since 1.0
 **/
public class Stem extends Root {
    C1 c1;
    C2 c2;
    C3 c3;

    public Stem() {
        c1 = new C1();
        c2 = new C2();
        c3 = new C3();
        System.out.println("Stem");
    }
    public static void main(String[] args) {
        Stem stem = new Stem();
    }

    protected void finalize(){
        System.out.println("Stem clean");
    }

    @Override
    public String toString() {
        return "Stem{" +
                "c1=" + c1 +
                ", c2=" + c2 +
                ", c3=" + c3 +
                ", c1=" + c1 +
                ", c2=" + c2 +
                ", c3=" + c3 +
                '}';
    }
}
