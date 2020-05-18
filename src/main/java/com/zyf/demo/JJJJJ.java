package com.zyf.demo;

import com.fingard.rabbit.cloudtools.common.util.EncryptUtils;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2020/5/18 17:02
 * @since 1.0
 **/
public class JJJJJ {
    public static void main(String[] args) {
        String userName = "superadmin";
        String userPwd = "111111";
        String password = EncryptUtils.encryptString("MD5", userName + userPwd);
        System.out.println("密码加密后为：" + password);
    }
}

class MMM {
    public static void main(String[] args) {
        String password = "4c46f2e1706c97ad404393fa22560b3b";
        String userName = "clearlove";
        String userPwd = EncryptUtils.decryptString("DESede",  password);
        System.out.println("密码原文是：" + userPwd);
    }
}