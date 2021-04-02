package com.springsecret.chapter9;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * MyMethodInterceptor
 *
 * @author Alphonse
 * @version 1.0
 * @date 2021/3/17 16:15
 **/
public class MyMethodInterceptor1 implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        try {
            System.out.println("方法A");
            Object o = methodInvocation.proceed();
            return ((Integer) o) * 0.8;
        } catch (Exception e) {
            System.out.println("异常A");
            return 0;
        } finally {
            System.out.println("方法A: finally");
        }
    }
}
