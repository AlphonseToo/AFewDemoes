package com.zyf.demo.mybuilder;

import lombok.Builder;

public class Mine {
    private String a;
    private int b = 1;

    @Builder(toBuilder = true)
    public Mine(String a, int b) {
        this.a = a;
        this.b = b;
    }

    @Builder(toBuilder = true)
    public Mine(String a) {
        this.a = a;
    }
}
