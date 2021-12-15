package com.springsecret.chapter78;

import java.lang.reflect.Proxy;

/**
 * Test1
 *
 * @author Alphonse
 * @version 1.0
 * @date 2021/3/16 18:00
 **/
public class MyInvocationHandlerTest extends Requestable {

    void test() {
        MyRequest myRequest = new MyRequest();
        IRequest iRequest = (IRequest)Proxy.newProxyInstance(
                myRequest.getClass().getClassLoader(),
                new Class[]{IRequest.class},
                new MyInvocationHandler(myRequest));
        iRequest.request();
    }

    void test1() {
        IRequest myRequest = new MyRequest();
        IRequest iRequest = (IRequest)new MyInvocationHandler().myNewProxyInstance(myRequest);
        iRequest.request();
    }

    public static void main(String[] args) {
        MyInvocationHandlerTest test = new MyInvocationHandlerTest();
        test.test();
        test.test1();
    }
}
