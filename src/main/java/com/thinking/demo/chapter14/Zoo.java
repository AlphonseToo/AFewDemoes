package com.thinking.demo.chapter14;

import java.lang.reflect.Method;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/11/15 14:08
 * @since 1.0
 **/
public class Zoo {
    public static void main(String[] args) {
        T2 re = new T2();
        try {
            Method m1 = re.getClass().getDeclaredMethod("f1");
            Method m2 = re.getClass().getDeclaredMethod("f2");
            Method m3 = re.getClass().getDeclaredMethod("f3");
            m1.invoke(re);
            m2.setAccessible(true);
            m2.invoke(re);
            m3.invoke(re);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
