package com.thinking.demo.chapter10;

/**
 * ~~~~
 *
 * @author Alphonse
 * @date 2019/10/30 16:26
 * @since 1.0
 **/
interface U{
    void f();
    void g();
    void h();
}
class A{
    U aa(){
        return new U() {
            @Override
            public void f() {
                System.out.println("A.Inner.f");
            }

            @Override
            public void g() {
                System.out.println("A.Inner.g");
            }

            @Override
            public void h() {
                System.out.println("A.Inner.h");
            }
        };
    }
}
class B{
    U[] uus = new U[3];
    void add(U us, int i){
        uus[i] = us;
    }
    void setNull(int i){
        uus[i] = null;
    }
    void print(){
        for (U u:
             uus) {
            u.f();
        }
    }

    public static void main(String[] args) {
        A[] as = new A[]{new A(), new A(), new A()};
        B b = new B();
        for (int i = 0; i < 3; i++) {
            b.add(as[i].aa(), i);
        }
        b.print();
        b.setNull(2);
    }
}
public class E23 {
}
