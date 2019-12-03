package com.thinking.demo.chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/12/2 14:24
 * @since 1.0
 **/

class LiffOff implements Runnable {
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiffOff() {
    }

    public LiffOff(int countDown) {
        this.countDown = countDown;
    }
    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "Liffoff!") + "),";
    }
    @Override
    public void run() {
        while(countDown-- > 0) {
            System.out.print(status());
//            Thread.yield(); //终止当前线程
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class T1 {
    public static void main(String[] args) {
        LiffOff launch = new LiffOff();
        launch.run();

        Thread t = new Thread(new LiffOff(), "tt");
        t.start();
        ExecutorService exec = Executors.newCachedThreadPool();
        ExecutorService exec1 = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            //new Thread(new LiffOff()).start();
            exec.execute(new LiffOff());
        }
        System.out.println("\nWaiting for LiftOff");
        exec.shutdown();
    }
}
