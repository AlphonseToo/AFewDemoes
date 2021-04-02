package com;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * dto
 *
 * @author Alphonse
 * @version 1.0
 * @date 2020/9/16 15:19
 **/
@Data
public class Dto {
    private String extField1;
    private String extField2;
    private String extField3;
    private String userName;
    private String userCn;

    public static void main(String[] args) {
        String a = "EMPLOYEE::123456";
        String p = "EMPLOYEE.*";
        Pattern compile = Pattern.compile(p);
        Matcher matcher = compile.matcher(a);
        boolean matches = matcher.matches();
        System.out.println(matches);

        String s = null;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            s = String.valueOf(i);
            list.add(s);
        }
        System.out.println(list);
    }
}
