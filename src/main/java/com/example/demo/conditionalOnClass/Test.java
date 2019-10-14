package com.example.demo.conditionalOnClass;

import com.example.demo.conditionalOnClass.bean.Asy;
import com.example.demo.conditionalOnClass.config.MyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName: Test
 * @Description: Test
 * @Author: Alphonse
 * @Version: 1.0
 * @Date: 2019/10/12 17:46
 **/
public class Test {

    @Autowired
    private Asy asy;
    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext2 = new AnnotationConfigApplicationContext(MyConfig.class);
        String[] beanNames = applicationContext2.getBeanDefinitionNames();
        for(int i=0;i<beanNames.length;i++){
            System.out.println("bean名称为==="+beanNames[i]);
        }
    }

    public void func1() {
        asy.gg();
    }
}
