package com.zz.chaos.y2022;

import cn.hutool.json.JSONObject;

import java.util.Map;

public class Demo0324 {

    public static void main(String[] args) {
        String extraInfo = "\0";
        Map<String, Object> extraInfoMap = new JSONObject(extraInfo).toBean(Map.class);
    }
}
