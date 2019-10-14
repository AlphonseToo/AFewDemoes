package com.example.demo.conditionalOnClass;

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

    @Autowired
    private Asy asy;
    public static void main(String[] args) {

        Test test = new Test();
        test.func1();
    }

    public void func1() {
        asy.gg();
    }
}
