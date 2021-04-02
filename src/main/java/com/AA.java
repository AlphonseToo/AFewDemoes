package com;

import java.util.HashMap;
import java.util.Map;

/**
 * AA
 *
 * @author Alphonse
 * @version 1.0
 * @date 2021/3/30 18:03
 **/
public class AA {
    public String funA() {
        try {
            System.out.println("方法A");
            return funB();
        } catch (Exception e) {
            System.out.println("异常A");
            return "null";
        } finally {
            System.out.println("方法A: finally");
        }
    }

    public String funB() throws Exception {
        try {
            System.out.println("方法B");
//            throw new Exception();
            return "B";
        } finally {
            System.out.println("方法B：finally");
        }
    }

    public static void main(String[] args) {
        AA aa = new AA();
        System.out.println(aa.funA());

        Map<String, Object> starQuickmenus = new HashMap<>();
        starQuickmenus.put("a", 1);
        starQuickmenus.put("b", "bb");
        starQuickmenus.put("a", (Integer)starQuickmenus.get("a") + 1);
        System.out.println(starQuickmenus);
        if ("bb".equals(starQuickmenus.get("b"))) {
            System.out.println("ss");
        }
    }
}
