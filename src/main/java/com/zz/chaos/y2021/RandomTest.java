package com.zz.chaos.y2021;

import cn.hutool.core.util.RandomUtil;

public class RandomTest {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            String s = RandomUtil.randomString(8);
            System.out.println(s);
        }
        String e = "zhuyf@fingard.com";
        String ff = "";
        System.out.println(e.endsWith(ff));
    }
}
