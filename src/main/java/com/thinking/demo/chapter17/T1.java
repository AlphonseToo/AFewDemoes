package com.thinking.demo.chapter17;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * ****
 *
 * @author Alphonse
 * @date 2019/11/21 14:30
 * @since 1.0
 **/
interface Generator<T>{
    T next();
}
class CollectionData<T> extends ArrayList<T> {
    public CollectionData(Generator<T> gen, int num) {
        for(int i = 0;i < num;i++) {
            add(gen.next());
        }
    }
    public static <T> CollectionData<T> list(Generator<T> gen, int num) {
        return new CollectionData<T>(gen, num);
    }
}
class Government implements Generator<String>{
    String[] foundation = ("strange women lying in ponds distributing swords is no basis for a system of government").split(" ");
    private int index;
    public String next() { return foundation[index++]; }
}
public class T1 {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>(new CollectionData<String>(new Government(), 10));
        System.out.println(set);
        set.addAll(CollectionData.list(new Government(), 10));
        System.out.println(set);
    }
}
