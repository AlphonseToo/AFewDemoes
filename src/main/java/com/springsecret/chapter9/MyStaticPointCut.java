package com.springsecret.chapter9;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * MyStaticPointCut
 *
 * @author Alphonse
 * @version 1.0
 * @date 2021/3/17 14:46
 **/
public class MyStaticPointCut extends StaticMethodMatcherPointcut {

    @Override
    public boolean matches(Method method, Class<?> aClass) {
        return method.getName().startsWith("get")
                && aClass.getPackage().getName().startsWith("chapter");
    }
}
