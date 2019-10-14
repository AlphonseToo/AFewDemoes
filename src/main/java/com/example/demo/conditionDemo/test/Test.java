package com.example.demo.conditionDemo.test;

import com.example.demo.conditionDemo.bean.MainConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName: Test
 * @Description: Test
 * @Author: Alphonse
 * @Version: 1.0
 * @Date: 2019/10/12 11:54
 **/

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext2 = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanNames = applicationContext2.getBeanDefinitionNames();
        for(int i=0;i<beanNames.length;i++){
            System.out.println("bean名称为==="+beanNames[i]);
        }
    }
}
