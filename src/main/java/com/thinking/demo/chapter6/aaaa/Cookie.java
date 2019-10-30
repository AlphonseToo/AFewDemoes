package com.thinking.demo.chapter6.aaaa;

/**
 * ~~~~~~~
 *
 * @author Alphonse
 * @date 2019/10/23 15:45
 * @since 1.0
 **/
class Cookie {
    public Cookie() {
        System.out.println("Cookie");
        String out = false ? "AAB" : false || true ? "100" : "001";
        System.out.println(out);
    }

    public static void main(String[] args){
        Cuqi cuqi = new Cuqi();
    }
    protected void f() {
        System.out.println("f()");

    }
}
