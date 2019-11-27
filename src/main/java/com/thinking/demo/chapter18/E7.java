package com.thinking.demo.chapter18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/11/26 15:52
 * @since 1.0
 **/
public class E7 {
    public static void main(String[] args) {
        String filename = "C:\\Users\\DELL\\Desktop\\1126.txt";
        String filename1 = "C:\\Users\\DELL\\Desktop\\1126_copy.txt";
        LinkedList<Integer> ll = new LinkedList<>();
        try{
            BufferedReader in = new BufferedReader(new FileReader(filename));
            int s;
            while((s = in.read()) != -1) {
                ll.add(s);
            }
            BufferedWriter out = new BufferedWriter(new FileWriter(filename1));
            while (ll.size() != 0) {
                out.write(ll.pollLast());
            }
            in.close();
            out.close(); // 不关闭不会有内容写入
        }catch (Exception e) {
            System.out.println("error occurred");
        }
    }
}
