package com.thinking.demo.chapter12;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/11/7 15:17
 * @since 1.0
 **/

class Ex1 extends Exception {
    public Ex1(String message) {
        super(message);
    }
}
class Ex2 extends Exception{
    public Ex2(String message) {
        super(message);
    }
}

public class E10 {
    void f() throws Ex2{
        try{
            g();
        }catch (Exception e) {
            throw new Ex2("222");
        }
    }
    void g() throws Ex1{
        throw new Ex1("111");
    }

    public static void main(String[] args) {
        E10 e10 = new E10();
        try {
            e10.f();
            e10.g();
        }catch (Ex2 e) {
            System.out.println("Here is Ex2:" + e.getMessage());
        }catch (Ex1 e){
            System.out.println("Here is Ex1");
        }
    }

}
