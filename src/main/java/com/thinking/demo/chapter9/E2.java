package com.thinking.demo.chapter9;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/10/28 16:37
 * @since 1.0
 **/

class C21{
    interface I21{
        int i = 0xfff;
        int xcx();
    }
}

class C22 extends C21{

}

class C23 implements C22.I21{
    @Override
    public int xcx() {
        return 12;
    }
}

interface Inter{
    int i = 1;
    int fun();
}
public class E2 implements Inter{

    @Override
    public int fun() {
        return 2;
    }

    public static void main(String[] args){
        E2 e2 = new E2();
        System.out.println(e2.fun());
        C22 c22 = new C22();
        C23 c23 = new C23();
        System.out.println(c23.xcx());
    }
}
