package com.zz.chaos.y2022.PDemo0219;

public class Class2 extends Class1{

    String fun1(String a, String b) {
        super.fun(a, b);
        return "haha";
    }

    public static void main(String[] args) {
        Class2 class2 = new Class2();
        class2.fun("a", "b");
    }
}
