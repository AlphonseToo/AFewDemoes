package com.zz.chaos.y2022;

import java.util.HashMap;
import java.util.Map;

public class Demo0121 {

    public static void main(String[] args) {
        String s = "123<:>";
        String[] split = s.split("<:>");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        fun(objectObjectHashMap);
        System.out.println(objectObjectHashMap.get("1"));
    }

    public static void fun(Map<String, Object> extraInfo) {
        extraInfo.put("1", "12456");
    }
}
