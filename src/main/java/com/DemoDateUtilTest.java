package com;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.math.BigDecimal;
import java.text.DecimalFormat;
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

        String s2 = "Wed Sep 01 2021 00:00:00 GMT+0800 (中国标准时间)";

        String view = "###,##0";
        DecimalFormat df = new java.text.DecimalFormat(view);
        System.out.println(df.format(56));
        BigDecimal bigDecimal = new BigDecimal("1234.01234567891");
        for (int i = -1; i < 9; i++) {
            String digitalView = getDigitalView(i);
            DecimalFormat df1 = new java.text.DecimalFormat(digitalView);
            String format2 = df.format(bigDecimal);
            System.out.println("F" + i + ": " + digitalView + " " + format2);
        }
    }

    private static String getDigitalView(int digit) {
        StringBuilder view = new StringBuilder("###,##0");
        if (digit == 0) {
            return view.toString();
        }
        view.append(".");
        if (digit < 0) {
            view.append("00");
        } else {
            for (int i = 1; i <= digit; i++) {
                view.append("0");
            }
        }
        return view.toString();
    }
}
