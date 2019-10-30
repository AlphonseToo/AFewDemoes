package com.thinking.demo.chapter10;

/**
 * ~~~~~
 *
 * @author Alphonse
 * @date 2019/10/29 14:47
 * @since 1.0
 **/
interface Inter{
    void f();
}
class Outer{
    private String ss = "cxv";
    private int i = 90;
    class Inner{
        void f(){
            System.out.println(i);
        }
        Outer getParent(){
            return Outer.this;
        }
        @Override
        public String toString() {
            return "Inner{}" + ss;
        }
    }
    Inner getInner(){
        return this.new Inner();
    }
}
public class E1 {
    public static void main(String[] args){
        Outer outer = new Outer();
        Outer.Inner inner = outer.getInner();
        Outer.Inner inner1 = outer.new Inner();
        inner.f();
        System.out.println(inner.toString());
        Outer oo = inner.getParent();
        System.out.println(oo.equals(outer));
        System.out.println(oo.toString());
        System.out.println(outer.toString());
    }
}
