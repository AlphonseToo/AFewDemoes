package com.zz.chaos.y2021;

import cn.hutool.json.JSONUtil;

public class RegMatch {

    public static void main(String[] args) {
        String source = "select sysdate() from t";
        String reg = "sysdate\\(\\)";
        String s = source.replaceAll(reg, "sysdate");
        System.out.println("quote: " + JSONUtil.toJsonStr(s));
    }
}