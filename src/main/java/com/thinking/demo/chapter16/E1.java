package com.thinking.demo.chapter16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * E1
 * 只能在声明的时候才能进行聚集初始化
 * comparable可以理解为内置的比较方法，它依赖于某个要比较的类，接口里只有一个int compareTo(T o)方法，在这里面定义实现该接口的类比较规则，在调用该类的需要用到比较操作的方法时会默认调用该比较方法。
 * comparator是一个外置的比较器，它具有compare(T a, T b)方法，在这里定义比较规则，它是独立存在的，不依赖于待比较的某个类，如果要比较某两个对象的大小，须显式调用该方法。
 * @author Alphonse
 * @date 2019/11/21 08:58
 * @since 1.0
 **/
class Bery {}
public class E1 {
    static void f1(Bery[] beries) {
        for (Bery bery : beries
             ) {
            System.out.println(bery);
        }
        System.out.println(beries);
    }
    int[][] gen2Array(int x, int y, int start, int end) {
        int[][] intArrays = new int[x][y];
        Random random = new Random(47);
        for(int i = 0;i < x;i++) {
            for(int j = 0;j < y;j++) {
                intArrays[i][j] = random.nextInt(end-start) + start;
            }
        }
        return intArrays;
    }
    void print2Array(int[][] array) {
        System.out.println(Arrays.deepToString(array));
    }
    public static void main(String[] args) {
        Bery[] beries = {new Bery(), new Bery()};
        f1(beries);
        Arrays.deepToString(beries);
        E1 e1 = new E1();
        e1.print2Array(e1.gen2Array(3,4,5,10));
        List<String>[] ls;
        List[] la = new List[10];
        ls = (List<String>[])la;
        ls[0] = new ArrayList<String>();
        //ls[1] = new ArrayList<Integer>(); // error
        Object[] objects = ls;
        objects[1] = new ArrayList<Integer>();
        System.out.println(ls);
        List<Bery>[] beryS = (List<Bery>[])new List[10];
        for(int i = 0;i < 10;i++)
            beryS[i] = new ArrayList<Bery>();
        Integer[] integer = new Integer[]{1,2,3,4};
        Bery[] berry = new Bery[4];
        Arrays.fill(berry, new Bery());
        Bery[] cerry = new Bery[4];
        System.arraycopy(berry, 0, cerry, 0, berry.length);
        System.out.println("berry: " + Arrays.toString(berry));
        System.out.println("cerry: " + Arrays.toString(cerry));
    }
}
