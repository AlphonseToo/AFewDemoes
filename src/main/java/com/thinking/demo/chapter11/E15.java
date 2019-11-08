package com.thinking.demo.chapter11;

import java.util.Stack;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/11/1 15:16
 * @since 1.0
 **/
public class E15 {
    void calExp(String s){
        char[] chars = s.toCharArray();
        for (char c:
             chars) {
            System.out.println(c);
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if(c == '+') {
                stack.push(chars[++i]);
            }
            if(c == '-') {
                System.out.print(stack.pop());
            }
        }
    }

    public static void main(String[] args) {
        E15 e15 = new E15();
        String ss = "+U+n+c---+e+r+t---+a-+i-+n+t+y---+-+r+u--+l+e+s---";
        e15.calExp(ss);
        //ContainerMethod
    }
}
