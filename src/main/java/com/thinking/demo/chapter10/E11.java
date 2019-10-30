package com.thinking.demo.chapter10;

/**
 * ~~~~
 *
 * @author Alphonse
 * @date 2019/10/30 14:04
 * @since 1.0
 **/
interface I3{
    int f();
}
class C3{
    int i;

    public C3(int i) {
        this.i = i;
    }
    public C3(String i) {
        this.i = Integer.valueOf(i);
    }
    public int value(){
        return i;
    }
}

class Test{
    public I3 OnI3(){
        return new I3() {
            private int a = 9;
            @Override
            public int f() {
                return a;
            }
        };
    }

    /**
     * 在一个方法内定义一个匿名内部类，并且希望它使用一个在其外部定义的对象，那么编译器会要求其参数引用是final的。
     * @param ii
     * @return
     */
    public C3 getC3(int ii){
        ii = ii + 2;
        return new C3(ii){
            public int value(){
                //ii = 9;
                //ii = "789";
                return super.value()*10;
            }
        };
    }
    public static void main(String[] args) {
        Test test = new Test();
        I3 ii = test.OnI3();
        C3 c3 = test.getC3(45);
        System.out.println(ii.f());
        System.out.println(c3.value());
    }
}
public class E11 {
    private class Ci3 implements I3{
        @Override
        public int f() {
            return 100;
        }
    }

    I3 getObject(){
        return new Ci3();
    }

    public static void main(String[] args) {
        E11 e11 = new E11();
        I3 i3 = e11.getObject();
        Ci3 cc = (Ci3)i3;
        System.out.println(cc.f());
    }
}
