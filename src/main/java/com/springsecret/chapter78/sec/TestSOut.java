package com.springsecret.chapter78.sec;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@ComponentScan(basePackageClasses = {TestBean.class, AspectTest.class})
public class TestSOut {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("testxml.xml");
        TestBean bean = (TestBean) context.getBean("test");
        bean.test();
    }
}
