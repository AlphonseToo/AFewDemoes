package com;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * demooo
 *
 * @author Alphonse
 * @version 1.0
 * @date 2020/8/26 11:50
 **/
public class Demo {
    public static void main(String[] args) throws Exception, UnsupportedEncodingException {

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
                throw new Exception("CNAPSERVICE001");
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
        s.deleteCharAt(s.length() - 1);
        System.out.println("s:" + s);
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

        List<Integer> all = new ArrayList<>();
        for (int j = 0; j < 3; j++) {
            all.add(j + 1);
        }
        int inserted = 0;
        int insertNumsOnce = 10;
        while (inserted < all.size()) {
            List<Integer> portion;
            if (inserted + insertNumsOnce >= all.size()) {
                portion = all.subList(inserted, all.size());
            } else {
                portion = all.subList(inserted, inserted + insertNumsOnce);
            }
            System.out.println(portion);
            inserted += insertNumsOnce;
        }

        String str = "'1\"0`1''10\r\n2";
        str = str.replace('\'', '\0');
        str = str.replace('"', '\0');
//        str = str.replace('`', '\0');
        System.out.println(str);
        List<String> strings = loadSql("C:\\Users\\DELL\\Desktop\\test.sql");
        System.out.println(strings);
        for (String i1 : strings) {
            sqlToObject(i1);
        }
    }

    public static List<String> loadSql(String sqlFile) throws Exception {
        List<String> sqlList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(sqlFile), "GBK"))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(new String(line.getBytes()));
            }
        }

        // Windows 下换行是 \r\n, Linux 下是 \n
        String[] sqlArr = sb.toString().split("(;\\s+\\r\\n)|(;\\s+\\n)|(;)");
        for (String s : sqlArr) {
            String sql = s.replaceAll("--.*", "").trim();
            if (!sql.equals("")) {
                sqlList.add(sql);
            }
        }
        return sqlList;

    }

    static void sqlToObject(String sql) {
        if (!sql.substring(0, 6).toUpperCase().startsWith("INSERT") && !sql.substring(0, 6).toUpperCase().startsWith("PROMPT")) {
            return;
        }
        String head = sql.substring(0, sql.indexOf(")")).toUpperCase();
        String tail = sql.substring(sql.indexOf(")") + 1);
        String tableName = head.substring(head.indexOf("INTO") + 4, sql.indexOf("(")).trim();
        String colStr = head.substring(head.indexOf("(") + 1);
        String valueStr = tail.substring(tail.indexOf("(") + 1, tail.lastIndexOf(")"));
        String[] colList = colStr.split("(,\\s+)|(,)");
        String[] valueList = valueStr.split("(,\\s+)|(,)");

        // 可以附带模块名例如： `jats2519ygcjt`.`tsys_subtrans`
        System.out.println(tableName);
        System.out.println(colList);
        System.out.println(valueList);
    }

    private String removePunctuations(String str) {
        str = str.replace('\'', '\0');
        str = str.replace('"', '\0');
        str = str.replace('`', '\0');
        return str;
    }
}
