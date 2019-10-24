package com.example.demo.conditionalOnClass;

import com.example.demo.conditionalOnClass.bean.AClass;
import com.example.demo.conditionalOnClass.bean.Asy;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @ClassName: Test
 * @Description: Test
 * @Author: Alphonse
 * @Version: 1.0
 * @Date: 2019/10/12 17:46
 **/
public class Test {

    public static Boolean flag = true;
    @Autowired
    private Asy asy;
    public static void main(String[] args) {
        Test.condition();
    }

    public void func1() {
        asy.gg();
    }

    public static void condition() {
        if(Test.flag){
            AClass aClass = new AClass();
        }else{
            com.example.demo.conditionalOnClass.config.AClass aClass = new com.example.demo.conditionalOnClass.config.AClass();
        }
    }
}
