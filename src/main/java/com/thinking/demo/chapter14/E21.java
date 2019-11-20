package com.thinking.demo.chapter14;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * E21
 *
 * @author Alphonse
 * @date 2019/11/15 16:00
 * @since 1.0
 **/
interface Interface {
    void doSomething();
    void somethingElse(String arg);
}
class RealObject implements Interface {
    @Override
    public void doSomething() {
        System.out.println("do something");
        SimpleProxy.countDo++;
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("somethingElse " + arg);
        SimpleProxy.countElse++;
    }
}
class SimpleProxy implements Interface {
    private Interface proxied;
    public static int countDo = 0;
    public static int countElse = 0;
    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        System.out.println("SimpleProxy do something");
        countDo++;
        proxied.doSomething();
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("SimpleProxy somethingElse " + arg);
        countElse++;
        proxied.somethingElse(arg);
    }
}
class SimpleProxyDemo {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("yingyingying");
    }
    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
        System.out.println(SimpleProxy.countDo);
        System.out.println(SimpleProxy.countElse);
    }
}

class MethodSelector implements InvocationHandler {
    private Object proxied;

    public MethodSelector(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("interesting")) {
            System.out.println("Proxy detected the interesting method");
        }
        //System.out.println(proxy); // 在动态代理时，去调用proxy.toString()方法 ，此时由于是代理，所以会再次调用invoke来调用toString方法
        return method.invoke(proxied, args);
    }
}
interface SomeMethods {
    void boring1();
    void boring2();
    void boring3();
    void interesting(String arg);
}
class Implementation implements SomeMethods {
    public SomeMethods some;

    public Implementation() {
    }

    public Implementation(SomeMethods some) {
        this.some = some;
    }

    @Override
    public void boring1() {
        System.out.println("boring1");
    }

    @Override
    public void boring2() {
        System.out.println("boring2");
    }

    @Override
    public void boring3() {
        System.out.println("boring3");
    }

    @Override
    public void interesting(String arg) {
        System.out.println("interesting " + arg);
    }
}
public class E21 { //E23
    public static void main(String[] args) {
        SomeMethods proxy = (SomeMethods) Proxy.newProxyInstance(SomeMethods.class.getClassLoader(),
                new Class[]{SomeMethods.class},
                new MethodSelector(new Implementation()));
        proxy.boring1();
        proxy.boring2();
        proxy.boring3();
        proxy.interesting("yyy");
        SomeMethods someMethods = new Implementation();
        Implementation implementation = new Implementation(someMethods);
    }
}
