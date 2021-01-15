package com;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * B
 *
 * @author Alphonse
 * @version 1.0
 * @date 2021/1/13 15:56
 **/
@Component
public class B extends A implements ApplicationContextAware {

    private static ApplicationContext applicationContext = null;

    @Override
    protected void functionB() {
        System.out.println("方法BB");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        B.applicationContext = applicationContext;
    }


    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static void main(String[] args) {
        B b = new B();
        b.functionA();
        System.out.println(b.b);
        Map<String, Alph> beansOfType = B.getApplicationContext().getBeansOfType(Alph.class);
        System.out.println(beansOfType);
    }
}
