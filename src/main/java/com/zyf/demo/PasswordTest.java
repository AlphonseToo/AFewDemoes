package com.zyf.demo;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2020/4/27 10:11
 * @since 1.0
 **/
public class PasswordTest {
    public static void main(String[] args) {
        String pattern = "^(?![\\d]+$)(?![a-zA-Z]+$)(?![^\\da-zA-Z]+$).{6,32}$";
        /**
         * ^(?![\d]+$)(?![a-zA-Z]+$)(?![^\da-zA-Z]+$).{6,32}$
         * 数字+字母，数字+特殊字符，字母+特殊字符，数字+字母+特殊字符组合，而且不能是纯数字，纯字母，纯特殊字符
         */
        /**
         * ^(?![\d]+$)(?![a-zA-Z]+$)(?![!#$%^&*]+$)[\da-zA-Z!#$%^&*]{6,32}$
         * 上面的正则里所说的特殊字符是除了数字，字母之外的所有字符
         * 如果要限定特殊字符，例如，特殊字符的范围为 !#$%^&*
         */
        /**
         * ^(?=.*[0-9].*)(?=.*[a-zA-Z].*)(?=.*[!@#$%^&*?].*).{6,32}$
         * 由6到32位数字、字母、!@#$%^&*?字符组成!
         */
        String pwd = "272727@";
        if(pwd.matches(pattern)) {
            System.out.println("正确。");
        } else {
            System.out.println("错误。");
        }
    }
}
