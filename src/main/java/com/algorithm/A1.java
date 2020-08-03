package com.algorithm;

/**
 * 2,3,5,7 能被整除，这个数就是合数，否则就是质数
 * 题目：我们把只包含因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做是第一个丑数。
 * 求按从小到大的顺序的第1500个丑数
 *
 * @author Alphonse
 * @version 1.0
 * @date 2020/7/31 16:23
 **/
public class A1 {
    int[] a = new int[10000];
    int alg1(int n){
        int num = 0;
        int count = 0;
        while(count < n){
            num++;
            if (isUgly1(num)) {
                count++;
            }
        }
        return num;
    }
    boolean isUgly1(int n){
        while(n % 2 ==0){
            n = n/2;
        }
        while(n % 3 ==0){
            n = n/3;
        }
        while(n % 5 ==0){
            n = n/5;
        }
        return n==1;
    }

    int alg_2(int n) {
        int m1 = 1;
        int m2 = 1;
        int m3 = 1;
        a[1]=1;
        int index = 1;
        while(index < n) {
            int min = min(a[m1]*2, a[m2]*3, a[m3]*5);
            a[++index] = min;
            while(a[m1]*2 <= min) {
                m1++;
            }
            while(a[m2]*3 <= min){
                m2++;
            }
            while(a[m3]*5 <= min){
                m3++;
            }
        }
        return a[index];
    }
    int min(int x, int y, int z){
        if(x <= y && x <= z) return x;
        if(y <= x && y <= z) return y;
        return z;
    }
    public static void main(String[] args) {
        A1 a1 = new A1();
        long s1, s2;
        s1 = System.currentTimeMillis();
        System.out.println(a1.alg_2(1500));
        s2 = System.currentTimeMillis();
        System.out.println((s2-s1)/1000.0);
        System.out.println("*****************************");
        s1 = System.currentTimeMillis();
        System.out.println(a1.alg1(1500));
        s2 = System.currentTimeMillis();
        System.out.println((s2-s1)/1000.0);
    }
}
