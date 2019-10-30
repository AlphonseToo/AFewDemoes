package com.thinking.demo.chapter10;

/**
 *
 *
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
        //Base base = getBase(77);
        //base.f();
        Temp temp = new Temp();
        new Temp.Parcel();
        Parcel parcel = Ppp();
        MMA mma = new MMA();
        MMA.A mmaa = mma.new A();
        MMA.A.B mmab = mmaa.new B();
        mmab = (mma.new A()).new B();
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

    public MMA(A aa) {
        this.aa = aa;
    }
}
