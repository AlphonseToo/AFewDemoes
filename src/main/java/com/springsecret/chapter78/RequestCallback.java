package com.springsecret.chapter78;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * MyMethodInterceptor
 *
 * @author Alphonse
 * @version 1.0
 * @date 2021/3/16 17:43
 **/
public class RequestCallback implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if (method.getName().equals("request")) {
            System.out.println("Arrived here：MethodInterceptor");
            return methodProxy.invokeSuper(o, objects);
        }
        return null;
    }
}
