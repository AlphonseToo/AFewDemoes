package com.zyf.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 *
 * @author Alphonse
 * @date 2020/5/20 10:20
 * @since 1.0
 **/
public class SyncQuery {
    public static void main(String[] args) throws Exception {
        String dateStr1 = "20200517";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date last = sdf.parse(dateStr1);
        Date now = new Date();
        String dateStr2 = sdf.format(now);
        //System.out.println("last: " + last.toString());
        //System.out.println("now: " + now.toString());
        //System.out.println(now.compareTo(last));
        System.out.println("dateStr1: " + dateStr1 + " dateStr2: " + dateStr2 + "\n比较结果: " +dateStr2.compareTo(dateStr1));
    }
}
