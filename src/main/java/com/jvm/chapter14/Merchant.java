package com.jvm.chapter14;

public class Merchant<T extends Customer> {
    public double aPrice(T customer) {
        return 0.0d;
    }
}
