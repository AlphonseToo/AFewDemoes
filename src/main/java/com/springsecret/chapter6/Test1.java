package com.springsecret.chapter6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {

    public static void main(String[] args) {
//        BeanFactory factory = new XmlBeanFactory(new ClassPathResource("xx.xml"));
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"testxml.xml"}, true);
        context.getBean("test");
    }
}
