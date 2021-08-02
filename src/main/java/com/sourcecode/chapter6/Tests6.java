package com.sourcecode.chapter6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

public class Tests6 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("");
        String message = context.getMessage("test", new Object[]{"12 3"}, Locale.CHINA);
        System.out.println(message);
    }
}
