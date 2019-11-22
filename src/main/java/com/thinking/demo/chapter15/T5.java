package com.thinking.demo.chapter15;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Alphonse
 * @date 2019/11/20 09:28
 * @since 1.0
 **/
public class T5 {
    public static void main(String[] args) {
        Byte[] poss = {1,2,3,4,5,6,7};
        Set<Byte> mySet = new HashSet<>(Arrays.asList(poss));
        //Set<Byte> mySet2 = new HashSet<Byte>(Arrays.<Byte>asList((Byte)1,2,3));
        FixedSizeStack<String> stack = new FixedSizeStack<>(10);
        stack.push("as");
        //stack.push(45);
    }
}
class FixedSizeStack<T> {
    private int index = 0;
    private Object[] storage;
    public FixedSizeStack(int size) {
        storage = new Object[size];
    }
    public void push(T item) {
        storage[index++] = item;
    }
    public T pop() {
        return (T) storage[--index];
    }
    <T> void f(List<T> t){}
}

class A {void f(){}}
class B extends A{}
class Self <T extends Self<T>> {
    T element;
    Self<T> set(T arg) {
        element = arg;
        return this;
    }
    T get(){
        return element;
    }

    public static void main(String[] args) {

    }
}
