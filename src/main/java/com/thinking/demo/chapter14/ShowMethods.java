package com.thinking.demo.chapter14;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/11/14 17:33
 * @since 1.0
 **/

public class ShowMethods {
    private static String usage = "usage: ShowMethods qualified.class.name";
    public static Pattern p = Pattern.compile("\\w+\\.|.final|.native");
    String str;
    public static void main(String[] args) {
        if(args.length < 1) {
            System.out.println(usage);
            System.exit(0);
        }
        int lines = 0;
        try {
            Class<?> c = Class.forName("com.thinking.demo.chapter14." + args[0]);
            Method[] methods = c.getMethods();
            Constructor[] ctors = c.getConstructors();
            if (args.length == 1) {
                for(Method m : methods) {
                    System.out.println(p.matcher(m.toString()).replaceAll(""));
                }
                for(Constructor ctor : ctors) {
                    System.out.println(p.matcher(ctor.toGenericString()).replaceAll(""));
                }
                lines = methods.length + ctors.length;
            } else {
                for (Method m : methods) {
                    if(m.toString().indexOf(args[1]) != -1) {
                        System.out.println(p.matcher(m.toString()).replaceAll(""));
                        lines++;
                    }
                }
                for (Constructor ctor : ctors) {
                    if (ctor.toString().indexOf(args[1]) != -1) {
                        System.out.println(p.matcher(ctor.toString()).replaceAll(""));
                        lines++;
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }
}
