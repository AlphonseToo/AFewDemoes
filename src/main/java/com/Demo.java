package com;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.fingard.ats.core.exception.AtsBizException;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * demooo
 *
 * @author Alphonse
 * @version 1.0
 * @date 2020/8/26 11:50
 **/
public class Demo {
    public static void main(String[] args) throws ParseException, UnsupportedEncodingException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(new Date()));

        String accountNumber = "9223372036854775807";
        int end = accountNumber.length() / 2 + accountNumber.length() % 2;
        if (end > 18) { // 银行账户长度为32位 使用long来取值长度最长为0x7fffffffffffffffL，十进制为19位，故取前18位
            end = 18;
        }
        for (; end > 0; end--) {
            Long key;
            try {
                key = Long.parseLong(accountNumber.substring(0, end));
                System.out.println(key);
            } catch (Exception e) {
                throw new AtsBizException("CNAPSERVICE001", e);
            }
        }


//        Map<String, Object> map = new HashMap<>();
//        map.put("1", "2020-12-24");
//        Date endDate = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm.SSS").parse(map.get("1") + " 23:59:59.999");
//        System.out.println(endDate);
//        int i = new Date().compareTo(endDate);
//        System.out.println(i);
//        System.out.println(new Date());

        StringBuilder s = new StringBuilder();
        s.append("123");
        s.append(",");
        s.deleteCharAt(s.length()-1);
        System.out.println("s:"+s);
        String a = "2,3,4";
        String b = "2,3,1";
        String[] aList = a.split(",");
        String[] bList = b.split(",");
        Set<String> aSet = Arrays.stream(aList).collect(Collectors.toSet());
        Set<String> bSet = Arrays.stream(bList).collect(Collectors.toSet());
        System.out.println(aSet.containsAll(bSet));

        String start = "2020-01-04 08:30:30";
        String endd = "2020-01-04 10:20:30";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date sd = format.parse(start);
        Date ed = format.parse(endd);
        long i = DateUtil.between(sd, ed, DateUnit.MINUTE);
        System.out.println("耗时（分钟）：" + i);
    }
}
