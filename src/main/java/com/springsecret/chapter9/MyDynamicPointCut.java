package com.springsecret.chapter9;

import cn.hutool.core.util.ArrayUtil;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * MyDynamicPointCut
 *
 * @author Alphonse
 * @version 1.0
 * @date 2021/3/17 14:50
 **/
public class MyDynamicPointCut extends DynamicMethodMatcherPointcut {

    @Override
    public boolean matches(Method method, Class<?> aClass, Object... objects) {
        if (method.getName().startsWith("get")
                && aClass.getPackage().getName().startsWith("chapter")) {
            return ArrayUtil.isNotEmpty(objects);
        }
        return false;
    }
}
