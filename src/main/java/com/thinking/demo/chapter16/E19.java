package com.thinking.demo.chapter16;

import java.util.Arrays;

/**
 * ****
 * String类中的常量CASE_INSENSITIVE_ORDER，在自己定义的比较器中，先判断全部大写是否相等，在判断小写是否相等，是否多余
 * @author Alphonse
 * @date 2019/11/21 11:05
 * @since 1.0
 **/
class Qmn{
    int i;

    public Qmn(int i) {
        this.i = i;
    }
}
public class E19 {
    public static void main(String[] args) {
        Qmn[] q1 = new Qmn[4];
        Qmn[] q2 = new Qmn[4];
        Arrays.fill(q1, new Qmn(55));
        Arrays.fill(q2, new Qmn(55));
        System.out.println(Arrays.deepEquals(q1, q2));
        Qmn qq1 = new Qmn(66);
        Qmn qq2 = new Qmn(66);
        System.out.println("qq1: " + qq1 + " qq2: " + qq2);
        char c = 'B';
        char b = 'b';
        char cc = Character.toUpperCase(c);
        char bb = Character.toUpperCase(b);
        System.out.println(cc == bb);
        int[] a1 = new int[]{9,5,8,1,2,4,3};
        Arrays.sort(a1);
        int i = Arrays.binarySearch(a1, 3);
        System.out.println(Arrays.toString(a1) + "\ni: " + i);
    }
}
