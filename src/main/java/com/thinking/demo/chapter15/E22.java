package com.thinking.demo.chapter15;

import sun.net.www.content.text.Generic;

import java.lang.reflect.Constructor;

/**
 * ****
 *
 * @author Alphonse
 * @date 2019/11/19 11:52
 * @since 1.0
 **/
class ClassAsFactory<T> {
    Class<T> kind;

    public ClassAsFactory(Class<T> kind) {
        this.kind = kind;
    }
    public T create(int arg) {
        try {
            for(Constructor<?> ctor : kind.getConstructors()) {
                Class<?>[] params = ctor.getParameterTypes();
                if (params.length == 1) {
                    if(params[0] != int.class) {
                        return kind.cast(ctor.newInstance());
                    }
                }
            }
            Constructor<T> ct = kind.getConstructor();
            return ct.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
public class E22 {
    public static void main(String[] args) {
        ClassAsFactory<Qrt> fe = new ClassAsFactory(Qrt.class);
        Qrt fg = fe.create(1);
        if (fg == null) {
            System.out.println("Zzz");
        } else {
            System.out.println(fg);
        }
    }
}

class ArrayGR {
    static Generic[] gia;

    public static void main(String[] args) {
        gia = new Generic[10];
        gia[0] = new Generic();

    }
}
