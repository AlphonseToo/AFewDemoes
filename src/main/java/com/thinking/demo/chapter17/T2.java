package com.thinking.demo.chapter17;

import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/11/21 15:41
 * @since 1.0
 **/
class MyList extends AbstractList<Integer> {
    private int index;

    public MyList(int index) {
        if(index < 0) index = 0;
        this.index = index;
    }

    @Override
    public Integer get(int indexi) {
        return Integer.valueOf(indexi++);
    }

    @Override
    public int size() {
        return index;
    }
}

class MySet extends AbstractSet<Map.Entry<String, String>> {
    private int size = ConstConfig.alphabet.length;
    private int index = 0;

    public MySet(int size) {
        if(size <= this.size) this.size = size;
    }

    @Override
    public Iterator<Map.Entry<String, String>> iterator() {
        return new Iterator<Map.Entry<String, String>>() {
            @Override
            public boolean hasNext() {
                if(index < size) return true;
                return false;
            }

            @Override
            public Map.Entry<String, String> next() {
                int location = index++;
                return new Map.Entry<String, String>() {

                    @Override
                    public String getKey() {
                        return ConstConfig.alphabet[location][0];
                    }

                    @Override
                    public String getValue() {
                        return ConstConfig.alphabet[location][1];
                    }

                    @Override
                    public String setValue(String value) {
                        return value;
                    }
                };
            }
        };
    }

    @Override
    public int size() {
        return size;
    }
}
class MyMap extends AbstractMap<String, String> {
    private int size;

    public MyMap(int size) {
        this.size = size;
    }

    @Override
    public Set<Entry<String, String>> entrySet() {
        return new MySet(size);
    }
}

public class T2 {
    public static void main(String[] args) {
        MyList myList = new MyList(10);
        System.out.println(myList);
        MyMap myMap = new MyMap(27);
        System.out.println(myMap);
        List list = Arrays.asList(1,2,3);
        list.set(0, 33);
        List subList = list.subList(0, 1);
        //subList.add(5);
        //subList.remove(0);
        subList.set(0,77);
        /**
         * ArrayList生成的list大小是固定的，任何有关更改list大小的方法（比如：add、remove等）被调用
         * 都会抛出UnsupportedOperationException异常，但可以修改每个节点的值。
         * 另外，由一个List通过subList方法生成的子List的大小也是固定的，修改大小的操作都是未支持的。
         */
        // list.remove(1);
        // list.add(9);
        Collections.unmodifiableList(list);
        System.out.println(list);
        for (Integer a: myList
             ) {
            System.out.println(a);
        }
    }
}
