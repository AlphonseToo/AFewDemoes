package com.zz.chaos.y2022;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo0219 extends Thread {

    static  boolean flag = true;
    int i = 0;

    @Override
    public void run() {
        do {
            i++;
            System.out.println("i=" + i + ",flag=" + flag);
        } while (flag);
        System.out.println("i=" + i + ",flag=" + flag);
    }

    public static void main(String[] args) throws InterruptedException {
        Demo0219 demo0219 = new Demo0219();
        demo0219.start();
        Thread.sleep(1000);
        flag = false;
        System.out.println("finally i: " + demo0219.i);
    }

    public static class Demo02191 {

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

    public static class Demo02192 {

        void invoke(Object obj, Object... args) {
            System.out.println(obj);
            System.out.println(args.length);
        }
        void invoke(String s, Object obj, Object... args) {
            System.out.println("string: " + s);
            System.out.println(obj);
            System.out.println(args.length);
        }

        public static void main(String[] args) {
            Demo02192 demo02192 = new Demo02192();
            demo02192.invoke(null, 1);    // 调用第二个 invoke 方法
            demo02192.invoke(null, 1, 2); // 调用第二个 invoke 方法
            demo02192.invoke(null, new Object[]{1}); // 只有手动绕开可变长参数的语法糖，
        }
    }
}
