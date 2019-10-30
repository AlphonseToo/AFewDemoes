package com.thinking.demo.chapter10;

/**
 * ~~~~
 *
 * @author Alphonse
 * @date 2019/10/30 15:16
 * @since 1.0
 **/

class C15_1{
    int i;

    public C15_1(int i) {
        this.i = i;
    }
}
public class E15 {
    public C15_1 getCcc(int i){
        return new C15_1(i){
            public void f(){
                System.out.println(i);
            }
        };
    }

    public static void main(String[] args) {
        E15 e15 = new E15();
        e15.getCcc(50);
    }
}
