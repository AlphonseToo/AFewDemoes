package com.thinking.demo.chapter14;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/11/13 14:03
 * @since 1.0
 **/

interface Iface{
    int i = 47;
    void f();
}
class Base implements Iface {
    @Override
    public void f() {
        System.out.println("Base.f");
    }
}
class Composed{
    Base b;
}
class Derived extends Base {
    Composed c;
    String s;
}
public class E9 {
    static Set<Class<?>> alreadyDisplayed = new HashSet<>();
    static void printClasss(Class<?> c) {
        if(c == null) return;
        System.out.println(c.getSimpleName());
        Field[] fields = c.getDeclaredFields();
        if (fields.length != 0) {
            System.out.println("Fields: ");
        }
        for(Field field : fields) {
            System.out.println("   " + field);
        }
        for(Field field : fields) {
            Class<?> k = field.getType();
            if(!alreadyDisplayed.contains(k)) {
                printClasss(k);
                alreadyDisplayed.add(k);
            }
        }
        for(Class<?> k : c.getInterfaces()) {
            System.out.println("Interface: " + k.getName());
            printClasss(k.getSuperclass());
        }
        printClasss(c.getSuperclass());
    }
    public static void main(String[] args) throws Exception {
        String[] ss = new String[]{"Derived", "Composed", "Base"};
        for(String s : ss) {
            System.out.println("*******************************\nClass:  " + s);
            printClasss(Class.forName(Common.PACKAGE + s));
        }


    }
}
