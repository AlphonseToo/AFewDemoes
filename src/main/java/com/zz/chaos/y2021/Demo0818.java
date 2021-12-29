package com.zz.chaos.y2021;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SmUtil;
import cn.hutool.json.JSONObject;

public class Demo0818 {
    public static void main(String[] args) {
        String s = "{\"LOGIN_LOGO\":\"LOGIN_LOGO.png,shared/setting\",\"HOMEPAGE_LOGO\":\"HOMEPAGE_LOGO.png,shared/setting\",\"LOGIN_PICTURE\":\"LOGIN_PICTURE.png,shared/setting\"}";
        JSONObject path = new JSONObject(s);
        System.out.println(path);
        boolean b = false;
        System.out.println(b);
        System.out.println(IdUtil.simpleUUID());
        System.out.println(IdUtil.simpleUUID());
        System.out.println(IdUtil.simpleUUID());
        System.out.println(IdUtil.simpleUUID());
        System.out.println(IdUtil.simpleUUID());
        String sss = "2021-09";
        DateTime parse = DateUtil.parse(sss, "yyyy-MM");
        System.out.println(parse);

        String s1 = SmUtil.sm3("999999");
        String s2 = "56caaf03ecdd63bec8c73f0730184249297e0461ef0ee5b98a38fb5292748cf7";
        System.out.println(s2.equals(s1));
    }
}
