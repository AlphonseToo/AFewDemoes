package com.springsecret.chapter78;

import org.springframework.cglib.proxy.Enhancer;

/**
 * MyProxy
 *
 * @author Alphonse
 * @version 1.0
 * @date 2021/3/16 17:34
 **/
public class Test {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Requestable.class);
        enhancer.setCallback(new RequestCallback());
        Object o = enhancer.create();
        System.out.println(o instanceof Requestable);
        ((Requestable)o).request();
        Object test1 = new Requestable();
        System.out.println(test1 instanceof Requestable);
        System.out.println("-----------------------------");
        Enhancer enhance1r = new Enhancer();
        enhance1r.setSuperclass(IRequestProxy.class);
        enhance1r.setCallback(new RequestCallback());
        IRequestProxy o1 = (IRequestProxy)enhance1r.create(new Class[]{IRequest.class}, new Object[]{new MyRequest()});
        o1.request();
    }
}
