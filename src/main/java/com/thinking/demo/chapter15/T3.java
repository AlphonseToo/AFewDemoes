package com.thinking.demo.chapter15;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * E9/10
 *
 * @author Alphonse
 * @date 2019/11/18 16:46
 * @since 1.0
 **/
class GenericMethods {
    public <T, U, V> void f(T t, U u, V v){
        System.out.println(t.getClass().getSimpleName() + " " + u.getClass().getSimpleName() + " " + v.getClass().getSimpleName());
    }
}
public class T3 {
    ThreadLocal local = new ThreadLocal();

    public T3() {
        local.set("Local");
        local.remove();
    }

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f(1,2,3);
        gm.f(1.2, "ik", true);
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "11");
        map.put(2, "22");
        map.put(3, "33");
        map.values();
        map.keySet();
        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
        map.get(1);
        for (Map.Entry<Integer, String> entry : entrySet
             ) {
            System.out.println(entry.getKey() + entry.getValue());
        }
        System.out.println(new T3().local.get());

    }
}
