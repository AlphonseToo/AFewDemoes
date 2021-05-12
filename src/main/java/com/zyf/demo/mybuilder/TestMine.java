package com.zyf.demo.mybuilder;

public class TestMine {

    public static void main(String[] args) {
        Mine.MineBuilder builder = Mine.builder();
        Mine build = builder.a("1").b(1).build();
        System.out.println(builder.toString());
    }
}
