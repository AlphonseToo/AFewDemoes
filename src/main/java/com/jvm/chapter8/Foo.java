package com.jvm.chapter8;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;

public class Foo {

    private static void bar(Object o) {
        // ...
        System.out.println(o);
    }

    public static MethodHandles.Lookup lookup() {
        return MethodHandles.lookup();
    }

    public static void main(String[] args) throws Throwable {
        MethodHandles.Lookup lookup = Foo.lookup();
        Class<Foo> fooClass = Foo.class;
        Method method = fooClass.getDeclaredMethod("bar", Object.class);
        MethodHandle mh = lookup.unreflect(method);
        MethodType methodType = MethodType.methodType(void.class, Object.class);
        MethodHandle mh1 = lookup.findStatic(fooClass, "bar", methodType);
        // 非严格匹配，因为该方法加了PolymorphicSignature注解
        mh.invoke(2);
        mh1.invoke(1);
        // Exception: expected (Object)void but found (int)void
        // 严格匹配
        mh.invokeExact(2);
    }
}
