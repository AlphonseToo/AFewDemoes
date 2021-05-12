package com.zyf.demo;

import cn.hutool.core.swing.DesktopUtil;
import cn.hutool.core.util.DesensitizedUtil;

public class TestHutool {

    public static void main(String[] args) {
        String email = DesensitizedUtil.email("13006363121@163.com");
        System.out.println(email);
        String name = DesensitizedUtil.chineseName("王王是谁");
        System.out.println(name);
        String mobilePhone = DesensitizedUtil.mobilePhone("13006363121");
        System.out.println(mobilePhone);
        String password = DesensitizedUtil.password("123566");
        System.out.println(password);

        DesktopUtil.browse("https://www.baidu.com/");
    }
}
