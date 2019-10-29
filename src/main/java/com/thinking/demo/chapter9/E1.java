package com.thinking.demo.chapter9;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/10/25 16:05
 * @since 1.0
 **/

abstract class C11{
    int j = 2;
    public abstract void print();

    public C11() {
        print();
    }
}
public class E1 extends C11{
    private int i = 1;

    @Override
    public void print() {
        System.out.println(i);
    }

    public E1() {
        super();
    }
}

class Ex{
    public static void main(String[] args){
        E1 e1 = new E1();
        e1.print();
    }
}
