package com.thinking.demo.chapter17;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/11/22 09:34
 * @since 1.0
 **/
class Qmp extends Stack {
    public static final  <T> void fun(T t){
        System.out.println("lplp");
    }
}
public class T3 extends Qmp{
    public static void fun(){

        System.out.println("aabb");
    }

    public static void main(String[] args) {
        Qmp.fun(null);
        TreeSet ts = new TreeSet<>();
        ts.add("isdiah");
        ts.add("128_");
        ts.add("%*#&(");
        List<String> list = new ArrayList();
        Iterator<String> iterator = list.iterator();
        System.out.println(list.size());
        while (iterator.hasNext()) {
            System.out.println("here");
        }
    }
}
