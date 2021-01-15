package com.zyf.demo;

import java.util.List;

/**
 * ****
 *
 * @author Alphonse
 * @date 2020/4/28 16:16
 * @since 1.0
 **/
public class NullList {
    public static void main(String[] args) {
        List<String> list = null;
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println(list.toString());
    }
}
