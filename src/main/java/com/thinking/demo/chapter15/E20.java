package com.thinking.demo.chapter15;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/11/18 17:55
 * @since 1.0
 **/

interface Qwe{
    void f();
    void d();
}
class Qrt implements Qwe {
    public Qrt() {
        System.out.println("Qrt.con");
    }

    @Override
    public void f() {
        System.out.println("Qrt.f");
    }

    @Override
    public void d() {
        System.out.println("Qrt.d");
    }
    public void myFun() {
        System.out.println("Qrt.myFun");
    }
}
class Zxc{
    public <T extends Qwe> void zz(T t) {
        t.d();
        t.f();
    }
}
public class E20 {
    public static void main(String[] args) {
        Zxc zxc = new Zxc();
        zxc.zz(new Qrt());
    }
}
