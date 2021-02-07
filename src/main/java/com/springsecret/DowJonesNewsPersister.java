package com.springsecret;

/**
 * DowJonesNewsPersister
 *
 * @author Alphonse
 * @version 1.0
 * @date 2021/2/7 16:20
 **/
public class DowJonesNewsPersister implements IFXNewsPersister{

    @Override
    public void persisterNews() {
        System.out.println("保存新闻");
    }
}
