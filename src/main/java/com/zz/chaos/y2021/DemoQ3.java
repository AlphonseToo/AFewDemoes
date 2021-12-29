package com.zz.chaos.y2021;

import java.util.Scanner;

public class DemoQ3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        String[] split = in.split(",");
        int n1 = 0;
        int n2 = 0;
        int[] old = new int[6];
        int max = 0;
        for (int i = 0; i < split.length; i++) {
            old[i] = Integer.parseInt(split[i]);
            max = old[i] > max ? old[i] : max;
            if (old[i] <= 0 || old[i] > 9) {
                System.out.println(-1);
                return;
            }
            if (old[i] == 2 || old[i] == 5) {
                if (n1 > 0) {
                    System.out.println(-1);
                    return;
                }
                old[i+1] = 7-old[i];
                n1++;
                i++;
            } else if (old[i] == 6 || old[i] == 9) {
                if (n2 > 0) {
                    System.out.println(-1);
                    return;
                }
                n2++;
                old[i+1] = 15-old[i];
                i++;
            }

        }
        int[] nums = new int[split.length + n1 + n2];
        for (int i = 0, j = 0; i < nums.length; i++) {
            while (old[j] == 0 && (j-1)<old.length) {
                j++;
            }
            if ((j-1) < old.length) {
                nums[i] = old[j];
                j++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        int n = 0;
        int[] pre = new int[max];
        for (int i = 0; i < nums.length; i++) {
            pre[n++] = nums[i];
            if (n == max) {
                System.out.println(nums[i]);
                return;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (isEqual(nums[i], nums[j])) {
                    continue;
                }
                pre[n++] = nums[i]*10+nums[j];
                if (n == max) {
                    System.out.println(pre[n-1]);
                    return;
                }
            }
        }
    }
    public static boolean isEqual(int i, int j) {
        if (i == j) return true;
        if (i == 2 && j == 5) return true;
        if (i == 5 && j == 2) return true;
        if (i == 6 && j == 9) return true;
        if (i == 9 && j == 6) return true;
        return false;
    }
}
