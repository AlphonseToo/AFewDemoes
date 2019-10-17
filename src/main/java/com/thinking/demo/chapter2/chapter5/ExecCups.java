package com.thinking.demo.chapter2.chapter5;

import java.util.Arrays;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/10/16 19:28
 * @since 1.0
 **/

class Cup{
    Cup(int maker){
        System.out.println("Cup(" + maker + ")");
    }

    void f(int maker){
        System.out.println("f(" + maker + ")");
    }
}

class Cups{
    static Cup cup1;
    static Cup cup2;
    static {
        cup1 = new Cup(1);
        cup2 = new Cup(2);
    }
    Cups(){
        System.out.println("Cup()");
    }
}

class Practice{
    static void f() {
        System.out.println("a：" + a + " b：" + b);
        System.out.println(Arrays.toString(ab));
    }
    static int[] ab = new int[]{1,2,};
     {
        b = 1;
    }
    static int a = 1;
    static int b;
}
public class ExecCups {
    public static void main(String[] args) {
        System.out.println("Inside main()");
        //Practice.f();
        //Cups.cup1.f(99);
        Mass[] mass = new Mass[]{new Mass("mass"), null};

    }
    //static Cups cups1 = new Cups();
    //static Cups cups2 = new Cups();

}

class Mass{
    Mass(String s){
        System.out.println(s);
    }
    public static void main(String... args){
        for (String arg : args) {
            System.out.println(arg);
        }
        System.out.println(Arrays.toString(args));
    }
}

class NewVarArgs{
    static void printArray(Object... args){
        for (Object obj : args) {
            System.out.println(obj + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        printArray(47, 17.21, 89264849L, true);
        printArray(new A(), new A());
        Mass.main("111", "222", "333");
        Mass.main(new String[]{"111", "222", "333"});
        for (Spiciness s : Spiciness.values()
             ) {
            System.out.println(s + ", ordinal " + s.ordinal());
        }
    }
}

class A{}

enum Spiciness{
    NOT, MILD, MEDIUM, HOT, FLAMING
}