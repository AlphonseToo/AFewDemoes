package com.example.demo.conditionalOnClass.bean;

import lombok.Data;

/**
 * @ClassName: AClass
 * @Description: AClass
 * @Author: Alphonse
 * @Version: 1.0
 * @Date: 2019/10/12 17:46
 **/
@Data
public class AClass implements Asy {
    public AClass() {
        System.out.println("Debug....");
    }

    @Override
    public String gg() {
        return "Fight for aabb";
    }
}
