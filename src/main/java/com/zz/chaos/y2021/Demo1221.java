package com.zz.chaos.y2021;

public class Demo1221 {

    public static void main(String[] args) {
        String p = "(?<=\\().*(?=\\))";
        String s = "(1m,3)";
        boolean matches = s.matches(p);
        System.out.println(matches);
        String column = ",'sql1' 'sql2'";
        String replace = column.replace("，", ",");
        int index = column.lastIndexOf(',');
        String inField = "";
        if (index >= 0) {
            inField = column.substring(0, index);
        }
        String result =  "POSITION(" + column.substring(index+1) + " in " + inField + ")";
        System.out.println(result);
    }
}
