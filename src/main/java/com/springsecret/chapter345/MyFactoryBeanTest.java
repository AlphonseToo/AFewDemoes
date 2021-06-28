package com.springsecret.chapter345;

import cn.hutool.core.date.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * MyFactoryBeanTest
 *
 * @author Alphonse
 * @version 1.0
 * @date 2021/3/12 15:41
 **/
@Component
public class MyFactoryBeanTest {

    @Autowired
    private Date date;


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);
//        MyFactoryBeanTest myFactoryBeanTest = (MyFactoryBeanTest)applicationContext.getBean("myFactoryBeanTest");
        System.out.print("时间：");
//        System.out.println(myFactoryBeanTest.getDate());
        Object bean1 = applicationContext.getBean("myFactoryBean", "a");
        Object bean2 = applicationContext.getBean("&myFactoryBean");
        System.out.println("bean1: " + bean1.getClass());
        System.out.println("bean2: " + bean2.getClass());
        DateTime dateTime = (DateTime) bean1;
        System.out.println(dateTime.getFirstDayOfWeek().toChinese());
    }
}
