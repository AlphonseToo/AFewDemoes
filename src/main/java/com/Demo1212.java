package com;

import java.util.Scanner;

public class Demo1212 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int w = sc.nextInt();
        String[] nums = s.split(",");
        int[] pcks = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            pcks[i] = Integer.parseInt(nums[i]);
        }
        for (int i = 0; i < pcks.length; i++) {
            for (int j = i+1; j < pcks.length; j++) {
                if (pcks[i] > pcks[j]) {
                    int temp = pcks[i];
                    pcks[i] = pcks[j];
                    pcks[j] = temp;
                }
            }
        }
        int sum = 0;
        int n = 0;
        for (int i = 0; i < pcks.length; i++) {
            if (sum <= w) {
                sum += pcks[i];
                n++;
            } else {
                System.out.println(n-1);
                return;
            }
        }
        System.out.println(n);
    }
}
