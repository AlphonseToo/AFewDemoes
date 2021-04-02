package com.springsecret.chapter78;

/**
 * MyRequest
 *
 * @author Alphonse
 * @version 1.0
 * @date 2021/3/16 18:50
 **/
public class MyRequest implements IRequest{

    @Override
    public void request() {
        System.out.println("MyRequest!");
    }
}
