package com.zz.chaos.y2021;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContextListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

public class Demo0811 {
    public static void main(String[] args) {
        String sss = "abc'sss'";
        System.out.println(sss.replace("'", "''"));
        System.out.println(DispatcherServlet.class.getName());
        System.out.println(ServletContextListener.class.getName());
        System.out.println(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        System.out.println(ContextLoader.class.getName());

        String pattern = "###,##0";
        String value = "1.1234";
        java.text.DecimalFormat df = new java.text.DecimalFormat(pattern);
        value = df.format(new BigDecimal(value));
        System.out.println(value);

        int passwordValidTime = 2;
        if (passwordValidTime > 0) {
            Integer integer = new Integer(20210718);
//            Integer integer = null;
            String passModifyDateStr = integer.toString();
            Date passModifyDate = DateUtil.parse(passModifyDateStr, DatePattern.PURE_DATE_PATTERN).toJdkDate();
            long pwdModifiedInterval = DateUtil.betweenDay(passModifyDate, new Date(), true);
            if (pwdModifiedInterval > passwordValidTime) {
                System.out.println("ss");
            }
        }

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("1");
        list.add("2");
        System.out.println(list);
        HashSet<String> set = new HashSet<>(list);
        System.out.println(set);
    }
}
