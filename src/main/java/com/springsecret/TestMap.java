package com.springsecret;

import java.util.HashMap;
import java.util.Map;

/**
 * TestMap
 *
 * @author Alphonse
 * @version 1.0
 * @date 2021/3/11 17:12
 **/
public class TestMap {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("1", "11");
        map.put("2", "2");
        System.out.println(map);
    }
}
