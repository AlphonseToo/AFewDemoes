package com.thinking.demo.chapter15;


import java.util.Iterator;

/**
 * ****
 *
 * @author Alphonse
 * @date 2019/11/18 15:40
 * @since 1.0
 **/
class Finbonacci{
    private int count = 0;

    public Integer next() {return fib(count++);}
    private int fib(int n) {
        if(n < 2) return 1;
        return fib(n-2) + fib(n-1);
    }
}
class IterableFibonacci implements Iterable<Integer> {
    private Finbonacci finbonacci = new Finbonacci();
    private int size;

    public IterableFibonacci(int size) {
        this.size = size;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return size > 0;
            }

            @Override
            public Integer next() {
                size--;
                return finbonacci.next();
            }
        };
    }

    public static void main(String[] args) {
        IterableFibonacci fib = new IterableFibonacci(20);
        for (Integer i : fib
             ) {
            System.out.print(i + " ");
        }
    }
}
public class T2 {
}
