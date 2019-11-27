package com.thinking.demo.chapter18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * I/O重定向的是字节流不是字符流，所以要使用stream而不是Reader和Writer。
 *
 * @author Alphonse
 * @date 2019/11/26 16:32
 * @since 1.0
 **/
public class E14 {

    static String file1 = "C:\\Users\\DELL\\Desktop\\zz\\1126_1647.txt";
    static String file1_s = "C:\\Users\\DELL\\Desktop\\zz\\copy1.txt";

    static String file2 = "C:\\Users\\DELL\\Desktop\\zz\\1126_1647_copy.txt";
    static String file2_s = "C:\\Users\\DELL\\Desktop\\zz\\copy2.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader in1 = new BufferedReader(new FileReader(file1));
        BufferedReader in2 = new BufferedReader(new FileReader(file2));

        PrintWriter out1 = new PrintWriter(new BufferedWriter(new FileWriter(file1_s)));
        PrintWriter out2 = new PrintWriter(new FileWriter(file2_s));
        String s;
        int line;
        Long start;
        Long interval;
        byte[] bytes = in1.readLine().getBytes();
        boolean we = bytes[1] == 's';
        line = 1;
        start = System.nanoTime();
        while((s = in2.readLine()) != null) {
            out2.println(line++ + ": " + s);
        }
        interval = System.nanoTime() - start;
        System.out.println("Copy2: " + interval/1000_000_000.0);
        out2.close();

        line = 1;
        start = System.nanoTime();
        while((s = in1.readLine()) != null) {
            out1.println(line++ + ": " + s);
        }
        interval = System.nanoTime() - start;
        System.out.println("Copy1: " + interval/1000_000_000.0);
        out1.close();

        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        while ((s = stdin.readLine()) != null && s.length() != 0) {
            System.out.println(s.toUpperCase());
        }

    }
}
