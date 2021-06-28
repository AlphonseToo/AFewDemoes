package com.sourcecode.chapter5;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.PostConstruct;

public class School implements InitializingBean {

    void init() {
        System.out.println("init");
    }

    void init11() {
        System.out.println("init11");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("here1");
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aa.xml");
        System.out.println("sd");
        Object school2 = context.getBean("school2");
        System.out.println(school2);
    }
}
