package com.thinking.demo.chapter9;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

/**
 * ~~~~~~
 *
 * @author Alphonse
 * @date 2019/10/29 10:55
 * @since 1.0
 **/
interface CanFight{
    void fight();
}
interface CanSwim{
    void swim();
}
interface CanFly{
    void fly();
}
class Action{
    public void fight(){
        System.out.println("Action.fight");
    }
}
class Hero extends Action implements CanFight, CanSwim, CanFly{
    @Override
    public void swim() {
        System.out.println("Swim");
    }
    @Override
    public void fly() {
        System.out.println("fly");
    }

    @Override
    public void fight() {
        System.out.println("Hero.fight");
    }
}
public class E7 {
    public static void t(CanFight x){x.fight();}
    public static void u(CanSwim x){x.swim();}
    public static void v(CanFly x){x.fly();}
    public static void w(Action x){x.fight();}
    public static void main(String[] args){
        Hero h = new Hero();
        t(h);
        u(h);
        v(h);
        w(h);
    }
}
interface I1{}
interface I2 extends I1{}
interface I3 extends I1{}
interface I4 extends I2,I3{}

interface I5{
    void aa();
    void bb();
}
interface I6{
    void cc();
    void dd();
}
interface I7{
    void ee();
    void ff();
}
interface I8 extends I5, I6, I7{
    void gg();
}
abstract class uio{
    abstract void fgo();
}
class C9 extends uio implements I8{
    @Override
    public void aa() {
        System.out.println("aa");
    }

    @Override
    public void bb() {
        System.out.println("bb");
    }

    @Override
    public void cc() {
        System.out.println("cc");
    }

    @Override
    public void dd() {
        System.out.println("dd");
    }

    @Override
    public void ee() {
        System.out.println("ee");
    }

    @Override
    public void ff() {
        System.out.println("ff");
    }

    @Override
    public void gg() {
        System.out.println("gg");
    }

    @Override
    void fgo() {
        System.out.println("fgo");
    }
}

class C2{
    public static void r(I5 x){x.aa();}
    public static void s(I6 x){x.cc();}
    public static void t(I7 x){x.ee();}
    public static void u(I8 x){x.gg();x.aa();x.cc();x.ee();}
    public static void main(String[] args){
        C9 c9 = new C9();
        r(c9);
        s(c9);
        t(c9);
        u(c9);
        c9.fgo();
    }
}

class GenChar implements Readable{
    private static Random random = new Random(47);
    private static final char[] ALPH = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final char[] alph = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private int count;
    public GenChar(int count) {
        this.count = count;
    }
    @Override
    public int read(CharBuffer cb) throws IOException {
        if(count-- == 0)
            return -1;
        cb.append(ALPH[random.nextInt(ALPH.length)]);
        for (int i = 0; i < 3; i++) {
            cb.append(alph[random.nextInt(alph.length)]);
        }
        cb.append("  ");
        return 4;
    }

    public static void main(String[] args){
        Scanner s = new Scanner(new GenChar(5));
        while(s.hasNext()){
            System.out.println(s.next());
        }
        A a = new A();
    }
}

class A{
    interface B{
        void f();
    }
    private interface D{
        void f();
    }
    public class DImpl2 implements D{
        @Override
        public void f() {

        }
    }
    public D getD(){
        return new DImpl2();
    }
}
