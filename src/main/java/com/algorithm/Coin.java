package com.algorithm;

/**
 * 硬币问题
 *
 * @author Alphonse
 * @version 1.0
 * @date 2020/7/30 20:27
 **/
public class Coin {
    int[] coins = {1, 5, 10, 25};
    int[][] dp = new int[5][100001];
    /**
     * 有数量不限的硬币，币值为25分、10分、5分和1分，请编写代码计算n分有几种表示法?
     * dp[i][sum] = 用前i种硬币构成sum 的所有组合数
     * dp[i][sum] = dp[i-1][sum - 0*Vm] + dp[i-1][sum - 1*Vm] + dp[i-1][sum - 2*Vm] + ... + dp[i-1][sum - K*Vm]; 其中K = sum / Vm
     * dp[n] 表示总数为n的共有几种方法
     */
    int count(int n) {
        for (int i=0; i<coins.length;i++){
            dp[i][0] = 1;
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 0; k <= j/coins[i-1]; k++) {
                    dp[i][j] += dp[i-1][j-k*coins[i-1]];
                }
            }
        }
        for (int i = 0;i<coins.length;i++){

        }
        return dp[coins.length][n];
    }

    public static void main(String[] args) {
        Coin coin = new Coin();
        for (int i: coin.coins) {
            System.out.print(i+" ");
        }
        System.out.println();
        int[] n = {1,10,50,100};
        for (int i = 0; i < n.length; i++) {
            System.out.println(n[i] + ": " + coin.count(n[i]));
        }
    }
}
