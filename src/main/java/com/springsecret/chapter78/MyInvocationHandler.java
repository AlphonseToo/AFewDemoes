package com.springsecret.chapter78;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * MyInvocationHandler
 *
 * @author Alphonse
 * @version 1.0
 * @date 2021/3/16 20:18
 **/
public class MyInvocationHandler implements InvocationHandler {

    private Object o;

    public MyInvocationHandler(Object o) {
        this.o = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Arrived MyInvocationHandler!");
        return method.invoke(o, args);
    }

}
