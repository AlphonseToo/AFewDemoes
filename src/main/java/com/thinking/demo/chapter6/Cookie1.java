package com.thinking.demo.chapter6;

import com.thinking.demo.chapter6.aaaa.Cuqi;

/**
 * ~~~~~
 *
 * @author Alphonse
 * @date 2019/10/23 15:45
 * @since 1.0
 **/
class Cookie1 {
    public Cookie1() {
        System.out.println("Cookie");
        String out = false ? "AAB" : false || true ? "100" : "001";
        System.out.println(out);
    }

    public static void main(String[] args){
        Cuqi cuqi = new Cuqi();
        cuqi = null;
        System.out.println(cuqi);
    }
    protected void f() {
        System.out.println("f()");

    }
}
