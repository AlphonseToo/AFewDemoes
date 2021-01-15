package com.thinking.demo.chapter14;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * ****
 *
 * @author Alphonse
 * @date 2019/11/15 14:06
 * @since 1.0
 **/
public class T2 {
    int num;
    String name = "Kot";

    public T2(int num) {
        this.num = num;
    }

    public void f1() {
        System.out.println("public f1()");
    }
    private void f2() {
        System.out.println("private f2()");
    }
    void f3() {
        System.out.println("package f3()");
    }

    public static void main(String[] args) {
        try {
            Constructor con = T2.class.getConstructor(int.class);
            T2 re = (T2)con.newInstance(89);
            Method m1 = T2.class.getDeclaredMethod("f1");
            Method m2 = T2.class.getDeclaredMethod("f2");
            Method m3 = T2.class.getDeclaredMethod("f3");
            m1.invoke(re);
            m2.setAccessible(true);
            m2.invoke(re);
            m3.invoke(re);
            Field[] fields = T2.class.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field.get(re));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
