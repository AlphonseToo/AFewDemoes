package com.algorithm;

/**
 * 题目：把n个骰子仍在地上，所有骰子的点数和为s。输入n，打印s所有可能取值的概率。
 * 容易知道，有n个骰子的话，s的最小取值为n，最大取值为6n。
 *
 * 如果只有1个骰子，那么很简单，s取1，2，3，4，5，6的情况数均为1，概率为1/6；
 * 设想有n个骰子，出现和为s，我们可以这样考虑，如果第一个骰子有6中情况，
 * 取1，2，3，4，5，6；那么剩下的n-1个骰子的和则分别取s-1，s-2, s-3,s-4,s-5, s-6，
 * 我们将所有这些情况相加，就可以得出总的情况数。
 * f(s,n) = 1, n=1,s in [1,6]
 * f(s,n) = 0, n=1, s not in [1,6]
 * f(s,n)=f(s-1,n-1)+f(s-2,n-1)+f(s-3,n-1)+f(s-4,n-1)+f(s-5,n-1)+f(s-6,n-1)
 * ----------------------------------------------------------------
 * 如果无序
 * f(s,n)=求和f(s-i*Vm,n-1), 0<=i<=s/Vm, Vm=1,2,3,4,5,6, n=6
 * @author Alphonse
 * @version 1.0
 * @date 2020/8/12 16:12
 **/
public class A3 {
    private final double maxValue = 6;
    double fun(double sum, double n) {
        if (n==0) return 0;
        if (sum == 0) return 1;
        return 0;
    }
    double function(double sum, double n) {
        if (n <= 0) return 0;
        if (n == 1) {
            if (sum >= 1 && sum <= maxValue) return 1;
            else return 0;
        }
        double s = 0;
        for (int i = 1; i <= maxValue; i++) {
            s += function(sum-i, n-1);
        }
        return s;
    }

    void cab(double n) {
        System.out.println("和-种数");
        double max = Math.pow(maxValue, n);
        double[] arr = new double[(int)(max)];
        for (double i = n; i <= n*maxValue; i++) {
            arr[(int)(i)] = function(i, n);
            System.out.println((int)i + ": " + (int)arr[(int)(i)]);
        }
    }

    public static void main(String[] args) {
        A3 a3 = new A3();
        a3.cab(2);
        String a = (String) null;
    }
}
