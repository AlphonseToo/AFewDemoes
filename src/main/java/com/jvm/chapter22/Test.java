package com.jvm.chapter22;

public class Test {

    public static int bitCount(int i) {
        // HD, Figure 5-2
        i = i - ((i >>> 1) & 0x55555555);
        i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
        i = (i + (i >>> 4)) & 0x0f0f0f0f;
        i = i + (i >>> 8);
        i = i + (i >>> 16);
        return i & 0x3f;
    }
    public static void main(String[] args) {
        int sum = 0;
        long l = System.currentTimeMillis();
        for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {
//            sum += bitCount(i); // In a second run, replace with Integer.bitCount
            sum += Integer.bitCount(i); // In a second run, replace with Integer.bitCount
        }
        long l1 = System.currentTimeMillis();
        System.out.println(sum);
        System.out.println(l1-l);
        // 13609

    }
}
