package com.zz.chaos.y2022;

public class Demo0311 {

    public static void main(String[] args) {
        String regex = "[-|:]";
        String m1 = "64-BC-58-BF-72-78";
        String m2 = "64:BC:58:BF:72:78";
        System.out.println(m1.replaceAll(regex, ""));
        System.out.println(m2.replaceAll(regex, ""));
    }
}
