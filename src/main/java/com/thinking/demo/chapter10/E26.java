package com.thinking.demo.chapter10;

/**
 * 内部类
 *
 * @author Alphonse
 * @date 2019/11/1 10:11
 * @since 1.0
 **/

class WithInner{
    int i;
    class Inner{
        int i;
        public Inner(int i) {
            this.i = i;
        }
    }

    public WithInner(int i) {
        this.i = i;
    }
}

public class E26{
    class E26Inner extends WithInner.Inner {
        public E26Inner(WithInner wi, int i) {
            wi.super(i);
        }
    }
    E26Inner f(){
        WithInner wi = new WithInner(29);
        return new E26Inner(wi, 22);
    }
    public static void main(String[] args) {
        WithInner wi = new WithInner(29);
        E26 ii = new E26();
        E26Inner ee = ii.f();

    }
}