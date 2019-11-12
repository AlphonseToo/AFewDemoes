package com.thinking.demo.chapter13;

import java.util.Arrays;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/11/12 09:15
 * @since 1.0
 **/
public class Splitting {
    public static String knights = "Then, when you have found the shrubbery, you must "
            + "cut down the mightiest tree in the forest... "
            + "with... a herring.";

    public static void split(String regex) {
        System.out.println(Arrays.toString(knights.split(regex)));
    }

    public static void main(String[] args) {
        split(" ");
        split("\\W+");
        split("n\\W+");
        System.out.println((knights.matches("tree")));
        System.out.println(knights.replaceAll("[aeiou]", "_"));
    }
}
