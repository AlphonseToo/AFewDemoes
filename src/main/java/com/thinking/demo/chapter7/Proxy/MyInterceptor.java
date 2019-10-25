package com.thinking.demo.chapter7.Proxy;

import java.lang.reflect.Method;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/10/25 09:17
 * @since 1.0
 **/
public class MyInterceptor implements Interceptor {
    @Override
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("before");
        return true;
    }

    @Override
    public void around(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("around");
    }

    @Override
    public void after(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("after");
    }
}
