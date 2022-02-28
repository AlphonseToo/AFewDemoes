package com.zz.chaos.y2021;

import java.util.HashMap;
import java.util.Map;

public class Demo1229 {

    static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) {
        String s = "picc";
        String s2 = "PicC";
        System.out.println(s.equalsIgnoreCase(s2));
        Map<String, String> map = new HashMap<>();
        System.out.println(tableSizeFor(17));
        System.out.println(tableSizeFor(17));
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
