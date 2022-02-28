package com.zz.chaos.y2022;

public class Demo02192 {

    void invoke(Object obj, Object... args) {
        System.out.println(obj);
        System.out.println(args.length);
    }
    void invoke(String s, Object obj, Object... args) {
        System.out.println("string: " + s);
        System.out.println(obj);
        System.out.println(args.length);
    }

    public static void main(String[] args) {
        Demo02192 demo02192 = new Demo02192();
        demo02192.invoke(null, 1);    // 调用第二个 invoke 方法
        demo02192.invoke(null, 1, 2); // 调用第二个 invoke 方法
        demo02192.invoke(null, new Object[]{1}); // 只有手动绕开可变长参数的语法糖，
    }
}
