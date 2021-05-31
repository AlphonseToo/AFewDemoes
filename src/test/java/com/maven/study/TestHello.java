package com.maven.study;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestHello {

    @Test
    public void testSayHello() {
        HelloMaven helloMaven = new HelloMaven();
        String result = helloMaven.sayHello();
        assertEquals("Hello Maven", result);
    }
}
