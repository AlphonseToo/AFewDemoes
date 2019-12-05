package com.thinking.demo.chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/12/2 16:51
 * @since 1.0
 **/

class ExceptionThread implements Runnable{
    @Override
    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        try{
            ExecutorService exec = Executors.newCachedThreadPool();
            exec.execute(new ExceptionThread());
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}

class ExceptionThread2 implements Runnable {
    @Override
    public void run() {
        Thread t = Thread.currentThread();
        //System.out.println("run() by " + t);
        //System.out.println("eh = " + t.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}
class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught " + e);
    }
}
class HandlerThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        //System.out.println(this + " creating new Thread");
        Thread t = new Thread(r);
        System.out.println("created " + t);
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        //System.out.println("eh = " + t.getUncaughtExceptionHandler());
        //System.out.println("*****************************");
        return t;
    }
}
class CaptureUncaughtException {
    public static void main(String[] args) {
        /*Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler()); // 这个和下面的构造器来设置异常处理的作用一样
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread2());
        exec.shutdown();*/

        ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
        exec.execute(new ExceptionThread2());
        exec.shutdown();
    }
}


public class T3 {
}
