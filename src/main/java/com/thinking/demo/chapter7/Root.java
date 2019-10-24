package com.thinking.demo.chapter7;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/10/24 14:24
 * @since 1.0
 **/
public class Root {
    C1 c1;
    C2 c2;
    C3 c3;

    Root() {
        c1 = new C1();
        c2 = new C2();
        c3 = new C3();
        System.out.println("Root");
    }
}
