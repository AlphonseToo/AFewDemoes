package com.thinking.demo.chapter10.p2;

import com.thinking.demo.chapter10.p1.Inter;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/10/29 15:53
 * @since 1.0
 **/
public class Xdd {
    private int k = 1;
    protected class Cdd implements Inter{
        private int i = 9;
        public int j = 9;

        public Cdd() {
            i = 100;
            j = 101;
        }

        @Override
        public void f() {
            k = 2;
            pp();
            System.out.println(toString());
        }
        @Override
        public String toString() {
            return "Cdd{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }
    }
    protected void pp(){
        System.out.println("Xdd.pp()" + k);
    }

    void mm(){
        Cdd cdd = this.new Cdd();
        cdd.i = 10;
        cdd.j = 178;
        System.out.println(cdd.toString());
    }

    public static void main(String[] args){
        Xdd xdd = new Xdd();
        Cdd cdd = xdd.new Cdd();
        cdd.i = 0;
        cdd.f();
        System.out.println("******************");
        xdd.mm();
        System.out.println("******************");
        System.out.println(cdd.toString());
    }
}
/****
 * 练习6：由于Fio类继承自 Xdd ，它继承了Xdd的构造函数，Xdd的内部类的权限是protected，所以可以访问Xdd这个内部类，
 * 但是 Xdd 类的构造类是protected的，而且 Fio 并没有继承 Xdd 的构造函数,所以不同包且没有继承关系是不能访问到继承关系的。
 * 练习7：内部类是可以直接访问外部类的私有方法和私有域的，对外部类的属性域做的修改会影响到外部类的对象，等同于外部类自己调用执行；外部类访问内部类只能
 * 通过实例化内部类对象才能访问，而且是可以访问内部类的private的属性域的，但是实例化的对象影响不到外部类实际中内部类的域的值的，这应该很好理解。
 * 练习8：外部类是不能直接访问内部类的域和方法的，只能通过实例化的方法访问，且可以访问private元素。manual
 */
class Cooc{
    public static void main(String[] args){
        Xdd xdd = new Xdd();
        Xdd.Cdd cdd = xdd.new Cdd();
        cdd.j = 44;
    }
}