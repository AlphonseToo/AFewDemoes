package com.springsecret.chapter78;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * MyInvocationHandler
 *
 * @author Alphonse
 * @version 1.0
 * @date 2021/3/16 20:18
 **/
public class MyInvocationHandler implements InvocationHandler {

    private Object o;

    public MyInvocationHandler() {}

    public MyInvocationHandler(Object o) {
        this.o = o;
    }

    public Object myNewProxyInstance(Object o) {
        this.o = o;
        return Proxy.newProxyInstance(o.getClass().getClassLoader(), o.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Arrived MyInvocationHandler!");
        return method.invoke(o, args);
    }

}
