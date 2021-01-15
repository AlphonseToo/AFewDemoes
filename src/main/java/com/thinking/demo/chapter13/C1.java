package com.thinking.demo.chapter13;

import java.util.Formatter;

/**
 * ****
 *
 * @author Alphonse
 * @date 2019/11/8 13:47
 * @since 1.0
 **/
class Recursion{
    public String toString() {
        return "Recursion:" + super.toString() + "\n";
    }
}
public class C1 {
    public static void main(String[] args) {
        Recursion recursion = new Recursion();
        System.out.println(recursion);
        String ss = "as ss";
        ss.getBytes();
        String.valueOf(5);
        System.out.println(ss.intern());
        System.out.printf("Row%d\n", 1);
        System.out.format("Row%d\n", 2);
        Formatter f = new Formatter(System.err);
        int length = 15;
        String stream = "%-" + length + "s %" + length + "d\n";
        f.format(stream, "AAAAAAAA", 7);
        f.format(stream, "BBBBBBBBBB", 7);
    }
}
