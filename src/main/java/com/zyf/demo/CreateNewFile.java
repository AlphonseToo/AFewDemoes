package com.zyf.demo;

import java.io.File;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2020/4/15 17:28
 * @since 1.0
 **/
public class CreateNewFile {
    public static void main(String[] args) {
        //String filePath = "D:\\app\\dq\\sq\\1.txt";
        String filePath = "D:\\app\\aa\\bb\\aa";
        File file = new File(filePath);
        try {
            if (!file.exists()) {
                //file.createNewFile();
                if (!file.mkdirs()) {
                    throw new Exception();
                }
                //file.mkdir();
            }
            File file1 = new File(filePath + "/qq.txt");
            if (!file1.exists()) {
                file1.createNewFile();
            }
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
    }
}
