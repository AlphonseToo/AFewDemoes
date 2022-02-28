package com.zz.chaos.y2022;

import cn.hutool.core.util.StrUtil;

public class Demo0119 {

    public static void main(String[] args) {
        String s = "Ff";
        String digitStr = s.substring(1);
        int digit = 2;
        if (StrUtil.isNotBlank(digitStr)) {
            try {
                digit = Integer.parseInt(digitStr);
            } catch (NumberFormatException e) {
                // do nothing
            }
        }
        StringBuilder zeroPlaceholder = new StringBuilder();
        for (int i = 0; i < digit; i++) {
            zeroPlaceholder.append("0");
        }
        String pattern = "###,##0." + zeroPlaceholder;
        System.out.println(pattern);
    }
}
