package com.java;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型
 *
 * @author Alphonse
 * @version 1.0
 * @date 2020/8/5 17:21
 **/
public class Geniric {
    public static void main(String[] args) {
        List<String>[] a = new ArrayList[12];
        List[] ls = new ArrayList[10];
        List<Integer> l1 = new ArrayList<>(4);
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);
        List<String> l2 = new ArrayList<>(2);
        l2.add("01");
        l2.add("02");
        ls[0] = l1;
        ls[1] = l2;
        ls[2] = new ArrayList();
        a[0] = new ArrayList<>();
        a[0].add("ss");
        String ads = a[0].get(0);
        ls[0].add(2);
        ls[2].add(2);
        ls[2].add("21");
        String as = (String)ls[2].get(0);
        System.out.println("ss: " + as);
        for (Object o : ls[2]){
            System.out.println(o);
        }
    }
}
