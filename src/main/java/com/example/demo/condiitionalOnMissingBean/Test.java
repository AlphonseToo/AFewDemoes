package com.example.demo.condiitionalOnMissingBean;

import com.example.demo.condiitionalOnMissingBean.config.BeanConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName: Test
 * @Description: TODO
 * @Author: Alphonse
 * @Version: 1.0
 * @Date: 2019/10/12 14:02
 **/

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext2 = new AnnotationConfigApplicationContext(BeanConfig.class);
        String[] beanNames = applicationContext2.getBeanDefinitionNames();
        for(int i=0;i<beanNames.length;i++){
            System.out.println("bean名称为==="+beanNames[i]);
        }
    }
}
