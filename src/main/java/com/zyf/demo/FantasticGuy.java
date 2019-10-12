package com.zyf.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName: FantasticGuy
 * @Description: TODO
 * @Author: Alphonse
 * @Version: 1.0
 * @Date: 2019/9/24 20:21
 **/
@Component
@ConfigurationProperties(prefix = "man")
public class FantasticGuy {
    private String a;
    private String b;
    private Integer c;

    public void setA(String a) {
        this.a = a;
    }

    public void setB(String b) {
        this.b = b;
    }

    public void setC(Integer c) {
        this.c = c;
    }

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    public Integer getC() {
        return c;
    }

    @Override
    public String toString() {
        return "FantasticGuy{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c=" + c +
                '}';
    }
}
