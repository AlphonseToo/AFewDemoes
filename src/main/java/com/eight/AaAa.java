package com.eight;

public class AaAa implements Aa{
    @Override
    public String fun1() {
        return "ss";
    }

    public static void main(String[] args) {
        AaAa aaAa = new AaAa();
        System.out.println(aaAa.fun1());
    }
}
