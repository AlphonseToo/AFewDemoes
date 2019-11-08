package com.thinking.demo.chapter10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ~~~~~
 * @author Alphonse
 * @date 2019/10/30 14:46
 * @since 1.0
 **/

abstract class Base{
    public Base(int i) {
        System.out.println("Base constructor. i = " + i);
    }
    public abstract void f();
}

public class Temp {
    static class Parcel{
        private int i = 11;
        public int value(){
            return i;
        }
    }
    public static Parcel Ppp(){
        return new Parcel();
    }
    public static Base getBase(int i){
        return new Base(i) {
            {
                System.out.println("Inside instance initializer.");
            }
            @Override
            public void f() {
                System.out.println("In anonymous f()");
            }
            {
                System.out.println("All in end");
            }
        };
    }

    public static void main(String[] args) {
        Base base = getBase(77);
        base.f();
        Temp temp = new Temp();
        new Temp.Parcel();
        Parcel parcel = Ppp();
        MMA mma = new MMA();
        MMA.A mmaa = mma.new A();
        MMA.A.B mmab = mmaa.new B();
        mmab.h();
    }
}

class MMA{
    private void f(){}
    private A aa;
    class A{
        private void g(){}
        public class B{
            void h(){
                f();
                g();
            }
        }
    }

    public MMA() {
        this.aa = new A();
        Integer[] intList = {1,2,3};
        List<Integer> list = Arrays.asList(intList);
        list.add(89);
    }
}

class Egg2{
    protected class Yolk {
        public Yolk(){
            System.out.println("Egg2.Yolk()");
        }
        public void f(){
            System.out.println("Egg2.Yolk.f()");
        }
    }
    private Yolk y = new Yolk();
    public Egg2(){
        System.out.println("New Egg2");
    }
    public void insertYolk(Yolk yy){y = yy;}
    public void g(){y.f();}
}

class BigEgg2 extends Egg2 {
    public class Yolk extends Egg2.Yolk{
        public Yolk(){
            System.out.println("BigEgg2.Yolk()");
        }
        public void f(){
            System.out.println("BigEgg2.Yolk.f()");
        }
    }
    static
        class Inner{
            int i;

            public Inner(int i) {
                this.i = i;
                f();
            }
            void f(){
                System.out.println("i: " + i);
            }
    }
    public BigEgg2(){

        insertYolk(new Yolk());
    }
    public static void main(String[] args) {
        BigEgg2.Inner inner = new Inner(45);
        inner.f();
        Egg2 e2 = new BigEgg2();
        e2.g();
        new ArrayList<>();
    }
}