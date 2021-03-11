package com.springsecret;

import com.springsecret.chapter345.StringPrinter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * TestSpring
 *
 * @author Alphonse
 * @version 1.0
 * @date 2021/2/26 17:20
 **/
public class TestSpring {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:application.xml");
        DowJonesNewsListener listener = (DowJonesNewsListener)applicationContext.getBean("listener");
        System.out.println();
        listener.getNews();
        System.out.println();
        String[] listeners = applicationContext.getAliases("listener");
        System.out.print("别名：");
        for (String s : listeners) {
            System.out.print(s + ",");
        }
        System.out.println();
        StringPrinter printer = (StringPrinter)applicationContext.getBean("listener2");
        printer.print("s");
//        DowJonesNewsListener bean = (DowJonesNewsListener)applicationContext.getBean("listener2");
        System.out.println(printer);
    }
}
