package com.springsecret.chapter345;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Test
 *
 * @author Alphonse
 * @version 1.0
 * @date 2021/3/5 11:02
 **/
public class Test345 implements ApplicationContextAware {

    ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void excute() {
        PrinterHandle printerHandle = applicationContext.getBean(PrinterHandle.class);
        printerHandle.printChain();
        System.out.println();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println(name);
        }
        PrinterHandle bean = applicationContext.getBean(PrinterHandle.class);
        bean.printChain();
        String[] stringPrinters = applicationContext.getAliases("print1");
        System.out.print("别名：");
        for (String s : stringPrinters) {
            System.out.print(s + ",");
        }
    }
}
