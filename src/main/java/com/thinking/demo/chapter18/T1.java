package com.thinking.demo.chapter18;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/11/26 13:51
 * @since 1.0
 **/

class DirFilter implements FilenameFilter {
    private Pattern pattern;

    public DirFilter(String regex) {
        pattern = Pattern.compile(regex);
    }

    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }

    public static void main(String[] args) {
        String regex = ".*\\..*";
        String name = ".git";
        DirFilter dirFilter = new DirFilter(regex);
        System.out.println(dirFilter.accept(null, name));
    }
}
public class T1 {
    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        if(args.length == 0)
            list = path.list();
        else {
            list = path.list(new DirFilter(args[0]));
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for(String item : list) {
            System.out.println(item);
        }

    }
}
