package com.thinking.demo.chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * synchronized不仅可以同步控制方法、类，还可以同步控制代码块，使得同步的范围最小，对性能有利
 * localThread把线程中的变量保存在本地，这样可以保证不会出现竞争（通过get()和set()方法来获取和赋值）
 * @author Alphonse
 * @date 2019/12/3 09:13
 * @since 1.0
 **/
public class T4 implements Runnable {
    private static int count = 0;
    synchronized void f() {
        System.out.println("f() : " + count++);
    }
    public void run() {
        f();
        synchronized(this){
            count++;
        }
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            es.execute(new T4());
        }
        es.shutdown();
    }
}

class AtmoitTest implements Runnable {
    private int i = 0;
    public int getValue() {
        return i;
    }
    private synchronized void eventIncrement() {
        i++;
        i++;
    } //只是在i写入的时候有同步控制，读取的时候可以随时读取

    @Override
    public void run() {
        while(true)
            eventIncrement();
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        AtmoitTest at = new AtmoitTest();
        executorService.execute(at);
        while(true) {
            int val = at.getValue();
            if(val % 2 != 0) {
                System.out.println(val);
                executorService.shutdown();
                System.exit(0);
            }
        }
//        AtomicInteger ai = new AtomicInteger(2);
//        ai.addAndGet(5);
//        ai.compareAndSet(5,6);
    }
}

class SyncEvent{
    private int currentValue = 0;
    private Lock lock = new ReentrantLock();
    public synchronized int next(){
        lock.lock();
        try {
            ++currentValue;
            Thread.yield();
            ++currentValue;
            return currentValue;
        }finally {
            lock.unlock();
        }
    }
}
