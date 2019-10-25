package com.thinking.demo.chapter7.Proxy;

import java.lang.reflect.Method;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/10/25 09:13
 * @since 1.0
 **/
public interface Interceptor {
        public boolean before(Object proxy, Object target, Method method, Object[] args);
        public void around(Object proxy, Object target, Method method, Object[] args);
        public void after(Object proxy, Object target, Method method, Object[] args);
}
