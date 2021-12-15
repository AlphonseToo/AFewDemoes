package com.springsecret.chapter78.sec;

public class TestBean {
    private String testStr = "testStr";

    public String getTestStr() {
        return testStr;
    }

    public String setTestStr(String testStr) {
        return this.testStr = testStr;
    }

    public void test() {
        System.out.println("test");
    }
}
