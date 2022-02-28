package com.zz.chaos.y2022;

import cn.hutool.core.util.StrUtil;

import java.util.HashSet;
import java.util.Set;

public class Demo0228 {
    public static void main(String[] args) {
        Set<String> strings = new HashSet<>();
        String s = "a b c";
        String b = s.replace("[ ]*b[ ]*", "b");
        String b1 = s.replace(" b ", "b");
        System.out.println(b);
        System.out.println(b1);
        String b2 = StrUtil.replace(s, "[ ]*b[ ]*", (p) -> {
            String group = p.group();
            String substring = group.substring(1);
            return substring;
        });
        System.out.println(b2);
    }
}
