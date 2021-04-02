package com.springsecret.chapter78;

/**
 * MySubject
 *
 * @author Alphonse
 * @version 1.0
 * @date 2021/3/16 18:50
 **/
public class MySubject implements ISubject {

    @Override
    public void request() {
        System.out.println("MySubject!");
    }
}
