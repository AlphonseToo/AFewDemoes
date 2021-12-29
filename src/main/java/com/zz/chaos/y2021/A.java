package com.zz.chaos.y2021;

import org.springframework.stereotype.Component;

/**
 * A
 *
 * @author Alphonse
 * @version 1.0
 * @date 2021/1/13 15:53
 **/
@Component
public class A implements Alph {

    private int a = 0;

    protected int b = 1;

    public int c = 2;

    public void functionA() {
        functionC();
    }

    protected void functionB() {
        System.out.println("方法B");
    }

    private void functionC() {
        System.out.println("function C");
        functionB();
    }

    public static void main(String[] args) {
        String objectName = "1weq.txt";
        System.out.println(objectName.lastIndexOf("."));
        System.out.println(objectName.substring(objectName.lastIndexOf(".")));
    }
}
