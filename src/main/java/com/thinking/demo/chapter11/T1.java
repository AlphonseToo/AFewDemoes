package com.thinking.demo.chapter11;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/11/1 15:21
 * @since 1.0
 **/
public class T1 {
    public static void main(String[] args) {
        Random random = new Random(47);
        Set<Integer> intset = new HashSet<>();
        for (int i = 0; i < 50; i++) {
            intset.add(random.nextInt(30));
        }
        Map<Integer, String> map = new HashMap();
        map.put(3, "333");
        map.put(13, "1333");
        map.put(1, "111");
        map.put(2, "222");
        System.out.println(map);
        System.out.println(intset.size());
        System.out.println(intset);

    }
}
