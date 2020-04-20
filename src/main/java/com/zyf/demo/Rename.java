package com.zyf.demo;

import java.io.File;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2020/3/16 15:50
 * @since 1.0
 **/
public class Rename {
    public static void main(String[] args) {
        File file = null;
        File file1 = null;
        String path = "D:\\Fubontmp\\10760/2020/202003/20200316/87b15cd6fb04474c99ff9089599a48fb_08c5f9bafa9645969216acc35e652eea.zip";
        //String path1 = "C:\\Users\\DELL\\Desktop\\zz\\sdsa.txt";
        String fileName = "币种_11111_admin";
        file = new File(path);
        file1 = new File(file.getParent(), fileName + ".zip");
        boolean a = file.renameTo(file1);
        System.out.println(path);
        System.out.println(file1.getAbsolutePath());
        System.out.println(a);
        System.out.println(file1.exists());
    }
}
