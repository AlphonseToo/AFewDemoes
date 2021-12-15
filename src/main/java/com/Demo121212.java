package com;

import java.util.Scanner;

public class Demo121212 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int arrNums = sc.nextInt();
        String[] arrays = new String[arrNums];
        int[] ls = new int[arrNums];
        int max = 0;
        sc.nextLine();
        for (int i = 0; i < arrNums; i++) {
            arrays[i] = sc.nextLine();
            ls[i] = (arrays[i].length()+1)/2;
            max = max < ls[i] ? ls[i] : max;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < (max+length-1)/length; i++) {
            for (int j = 0; j < arrNums; j++) {
                if (ls[j] > 0) {
                    if (ls[j] >= length) {
                        sb.append(arrays[j].substring(i*length*2, i*length*2+2*length-1));
                        ls[j] -= length;
                    } else {
                        sb.append(arrays[j].substring(i*length*2));
                        ls[j] = 0;
                    }
                    sb.append(",");
                }
            }
        }
        if(sb.length() == 0) {
            System.out.print(sb);
            return;
        }
        if (sb.charAt(sb.length()-1) == ',') {
            sb.deleteCharAt(sb.length()-1);
        }
        System.out.print(sb);
    }
}
