package com.zyf.demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * DemoSet
 *
 * @author Alphonse
 * @version 1.0
 * @date 2021/3/17 17:15
 **/
public class DemoSet {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("c");
        Set<String> set = new HashSet<>(list);
        System.out.println(set);
    }
}
