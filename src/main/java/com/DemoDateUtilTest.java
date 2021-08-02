package com;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.util.Date;

public class DemoDateUtilTest {
    public static void main(String[] args) {
        String s = "2021-06-05 12:15:16.123";
        String format = "yyyy-MM-dd HH:mm:ss";
        Date parse = DateUtil.parse(s, format);
        String format1 = DateUtil.format(parse, format);
        System.out.println(format1);

        String s1 = "2021年06月05日 12时15分16秒";
        DateTime parse1 = DateUtil.parse(s1);
        System.out.println(parse1);
    }
}
