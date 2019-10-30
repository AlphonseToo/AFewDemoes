package com.thinking.demo.chapter7.Proxy;

/**
 * ~~~~~~
 *
 * @author Alphonse
 * @date 2019/10/25 09:30
 * @since 1.0
 **/

interface Shopping{
    void buy();
}
class Client implements Shopping{
    public void buy(){
        System.out.println("买这件");
    }
}

public class InterceptorTest {
    public static void main(String[] args){
        InterceptorProxy interceptorProxy = new InterceptorProxy(new MyInterceptor());
        Shopping shopping = (Shopping) interceptorProxy.bind(new Client());
        shopping.buy();
    }
}
