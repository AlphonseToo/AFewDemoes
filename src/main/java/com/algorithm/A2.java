package com.algorithm;

/**
 * 3种方法求解斐波那契数列
 * f(0)=0,f(1)=1,f(n)=f(n-1)+f(n-2)
 * @author Alphonse
 * @version 1.0
 * @date 2020/8/10 15:49
 **/
public class A2 {
    // 递归
    static int f1(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return f1(n-2) + f1(n-1);
    }
    static int f2(int n){
        if (n == 0) return 0;
        if (n == 1) return 1;
        int first = 0;
        int second = 1;
        int cnt = 1;
        int fib = 0;
        while(cnt < n) {
            fib = first + second;
            first = second;
            second = fib;
            cnt++;
        }
        return fib;
    }
    public static void main(String[] args) {
        int n = 10;
        System.out.println(n + ": " + f1(n));
        System.out.println(n + ": " + f2(n));
    }
}
