package com;

import java.util.Scanner;

public class Demo12121 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int arrNums = sc.nextInt();
        String[] arrays = new String[arrNums];
        int[] ls = new int[arrNums];
        int max = 0;
        for (int i = 0; i < length; i++) {
            arrays[i] = sc.nextLine();
            ls[i] = (arrays[i].length()+1)/2;
            max = max < ls[i] ? ls[i] : max;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < (max+length-1)/length; i++) {
            int zero = 0;
            int p = 0;
            for (int j = 0; j < arrNums; j++) {
                if (ls[j] > 0) {
                    p = j;
                    if (ls[j] >= length) {
                        sb.append(arrays[j].substring(i*length*2, i*length*2+2*length-1));
                        ls[j] -= length;
                    } else {
                        sb.append(arrays[j].substring(i*length*2));
                        ls[j] = 0;
                    }
                    sb.append(",");
                } else {
                    zero++;
                }
            }
            if (zero == arrNums-1) {
               sb.append(arrays[p].substring((i+1)*length*2));
               break;
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
