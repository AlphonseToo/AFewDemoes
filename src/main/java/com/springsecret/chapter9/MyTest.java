package com.springsecret.chapter9;

/**
 * MyTest
 *
 * @author Alphonse
 * @version 1.0
 * @date 2021/3/22 15:27
 **/
public class MyTest {
    public String name = "MyTest.String";
    public class A {
        public String a = "A.String";
    }

    String getLocalAClassName() {
        return new A().getClass().getCanonicalName();
    }

    // local class
    String getLocalBClassName() {
        class B {
            public String b = "B.String";
        }
        return new B().getClass().getCanonicalName();
    }

    // anonymous class
    String getLocalCClassName() {
        return new InterfaceA(){}.getClass().getCanonicalName();
    }

    public static void main(String[] args) {
        MyTest myTest = new MyTest();
        System.out.println("----------------------");
        System.out.println("Class: " + myTest.getClass().getCanonicalName());
        System.out.println("Variable class: " + myTest.getLocalAClassName());
        System.out.println("Local class: " + myTest.getLocalBClassName());
        System.out.println("Anonymous class: " + myTest.getLocalCClassName());
    }
}
