package com.thinking.demo.chapter7;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/10/24 15:46
 * @since 1.0
 **/

class WithFinals{
    private final void f(){
        System.out.println("WithFinals.f()");
    }
    private void g(){
        System.out.println("WithFinals.g()");
    }
}

class OverridePrivate extends WithFinals{
    private final void f(){
        System.out.println("OverridePrivate.f()");
    }
    public void g(){
        System.out.println("OverridePrivate.g()");
    }
}

class OverridePrivate2 extends OverridePrivate{

    public final void f(){
        System.out.println("OverridePrivate2.f()");
    }
    public void g(){
        System.out.println("OverridePrivate2.g()");
    }
}
class SmallTalk{}
final class Dinosaur{
    int i = 7;
    int j = 1;
    SmallTalk st = new SmallTalk();
    void f(){
        System.out.println("Dinosaur.f()");
    }

    @Override
    public String toString() {
        return "Dinosaur{" +
                "i=" + i +
                ", j=" + j +
                ", st=" + st +
                '}';
    }
}

class Insect{
    private int i = 9;
    protected int j;
    Insect(){
        System.out.println("i="+i+"j="+j);
    }
    static {
        System.out.println("Insect static block1");
    }
    static int x1 = printInit("Insect.x1 initialized");
    static {
        System.out.println("Insect static block2");
    }
    static int printInit(String s){
        System.out.println(s);
        return 47;
    }
    void si(){}
}

public class FinalPrivate extends Insect{
    static {
        System.out.println("FinalPrivate static block");
    }
    void ff(){
        super.si();
    }
    public static void main(String[] args){
        /*OverridePrivate2 op2 = new OverridePrivate2();
        op2.f();
        op2.g();
        OverridePrivate op = op2;
        //op.f();
        op.g();*/
        Dinosaur n = new Dinosaur();
        n.f();
        n.i = 48;
        n.j++;
        System.out.println(n);
        //System.out.println(Insect.x1);
    }
}