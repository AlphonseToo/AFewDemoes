package com.springsecret;

/**
 * DowJonesNewsListener
 *
 * @author Alphonse
 * @version 1.0
 * @date 2021/2/7 16:19
 **/
public class DowJonesNewsListener implements IFXNewsListener{

    @Override
    public void getNews() {
        System.out.println("接收消息");
    }
}
