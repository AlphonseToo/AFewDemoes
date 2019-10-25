package com.thinking.demo.chapter7.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/10/25 09:19
 * @since 1.0
 **/
public class InterceptorProxy implements InvocationHandler {
    private Object target = null;
    Interceptor interceptor = null;

    public InterceptorProxy(Interceptor interceptor) {
        this.interceptor = interceptor;
    }

    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(interceptor == null){
            method.invoke(target, args);
            return null;
        }
        Object result = null;
        if(interceptor.before(proxy, target, method, args)){
            result = method.invoke(target, args);
        }else {
            interceptor.after(proxy, target, method, args);
        }
        interceptor.around(proxy, target, method, args);
        return result;
    }
}

class Study{
    void read(String name){
        System.out.println(name + " is reading.");
    }
}
class Person{
    String name;
    Study study;
    public Person(String name) {
        this.name = name;
        study = new Study();
    }
    void read(){
        study.read(name);
    }
    public static void main(String[] args){
        Person xiaoming = new Person("xiaoming");
        xiaoming.read();
    }
}