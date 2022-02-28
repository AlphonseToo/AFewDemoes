package com.zz.chaos.y2022;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo02191 {

    private static final CountDownLatch countDownLatch = new CountDownLatch(1000);
    private volatile int num = 0;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Demo02191 demo02191 = new Demo02191();
        for (int i = 0; i < 1000; i++) {
            executorService.submit(()-> {
                synchronized (Demo02191.class) {
                    try {
                        demo02191.num++;
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        countDownLatch.countDown();
                    }
                }
            });
        }
        System.out.println("finally num is : " + demo02191.num);
        countDownLatch.await();
        executorService.shutdown();
        System.out.println("finally num is : " + demo02191.num);
    }
}
