package com;

import cn.hutool.core.date.DateTime;
import com.fingard.ats.core.utils.AtsDateUtils;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

/**
 * demooo
 *
 * @author Alphonse
 * @version 1.0
 * @date 2020/8/26 11:50
 **/
public class Demo {
    public static void main(String[] args) throws ParseException, UnsupportedEncodingException {
        String dateTime = "2015-01-05 06:30:03.300";
        String dateTime1 = "20150105063003Z";
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss'Z'");
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        System.out.println(format.parse(dateTime1).getTime());
        //DateTime ti = AtsDateUtils.parse(dateTime1, format);
        DateTime ti = AtsDateUtils.parse(dateTime1, "yyyyMMddHHmmss'Z'");
        // ti.setTimeZone(TimeZone.getTimeZone("UTC"));
        //System.out.println(ti.toString(TimeZone.getTimeZone("UTC")));
        System.out.println(ti.getTime());

        String username = "fund01";
        String password = "uat@fund#";
        String au = username + ":" + password;
        BASE64Encoder base = new BASE64Encoder();
        String encodedPassword = base.encode(au.getBytes("UTF-8"));
        System.out.println(encodedPassword);

        StringBuilder message = new StringBuilder("12；");
        message.setCharAt(message.length() - 1, '1');
        String ss = message.toString();
        System.out.println(ss);
        Date date = AtsDateUtils.addHours(new Date(), -8);
        System.out.println(date);
        String sds = AtsDateUtils.format(date, "yyyyMMddHHmmss'Z'");
        System.out.println(sds);

        String dde = "@Z#S:OS&FD#%0.O@";
        String d1 = "nishis";
        String d2 = "你是";
        String s = d1 + dde + d2;
        String[] sspl = s.split(dde);
        System.out.println(sspl[0]);
        System.out.println(sspl[1]);

        Map<Integer, Integer> map111 = new HashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> entry : map111.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
        StringBuilder sb = new StringBuilder("我是测试");
        System.out.println(sb.substring(0, sb.length() > 4 ? 4 : sb.length()));
        String s1 = "@";
        String[] sss = s1.split("@");
        System.out.println(sss.length);

        Map<String, Object> map = new HashMap<>();
        map.put("ext_field_1", "1");
        map.put("ext_field_2", "2");
        map.put("ext_field_3", "3");
        map.put("user_name", "name");
    }
}
