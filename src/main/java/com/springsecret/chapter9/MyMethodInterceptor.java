package com.springsecret.chapter9;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * MyMethodInterceptor
 *
 * @author Alphonse
 * @version 1.0
 * @date 2021/3/17 16:15
 **/
@Component
public class MyMethodInterceptor implements MethodInterceptor {

    @Override
    @Resource
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        try {
            System.out.println("方法B");
            return methodInvocation.proceed();
        } finally {
            System.out.println("方法B: finally");
        }
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyMethodInterceptor.class, IntegerCal.class);
        IntegerCal integerCal = (IntegerCal)applicationContext.getBean("integerCal");
        int a = integerCal.fun(100);
        System.out.println(a);
    }
}
