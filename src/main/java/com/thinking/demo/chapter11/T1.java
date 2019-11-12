package com.thinking.demo.chapter11;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

/**
 * map
 *
 * @author Alphonse
 * @date 2019/11/1 15:21
 * @since 1.0
 **/

class MyComparator implements Comparator<T1> {
    @Override
    public int compare(T1 o1, T1 o2) {
        return o1.i > o2.i ? 1 : o1.i == o2.i ? 0 : -1;
    }
}

public class T1 {
    int i;
    public T1(int i) {
        this.i = i;
    }

    public static void main(String[] args) {
        Random random = new Random(47);
        Set<Integer> intset = new HashSet<>();
        for (int i = 0; i < 50; i++) {
            intset.add(random.nextInt(30));
        }
        Map<String, String> map = new HashMap();
        Map<T1, String> map1 = new TreeMap<>(new MyComparator());
        Queue queue = new LinkedList<Integer>();
        map.put("3", "333");
        map.put("12", "1333");
        map.put("1", "111");
        map.put("2", "222");
        System.out.println(map);
        System.out.println(intset.size());
        System.out.println(intset);

        Collection<String> cs = new LinkedList<>();
        Collections.addAll(cs, "Legends never die.".split(" "));
        for(String s : cs) {
            System.out.println(s);
        }
    }
}
