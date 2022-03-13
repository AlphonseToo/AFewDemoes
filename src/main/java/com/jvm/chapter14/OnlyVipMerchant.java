package com.jvm.chapter14;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class OnlyVipMerchant extends Merchant<Vip> {
    @Override
    public double aPrice(Vip customer) {
        return 0.1d;
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        OnlyVipMerchant merchant = new OnlyVipMerchant();
        Customer customer = new SVip();
        // 编译器报错
//        merchant.aPrice(customer);
        Method aPrice = OnlyVipMerchant.class.getMethod("aPrice", Customer.class);
        Object invoke = aPrice.invoke(merchant, customer);
        System.out.println(invoke);
    }
}
