package com.thinking.demo.chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ****
 *
 * @author Alphonse
 * @date 2019/12/2 14:24
 * @since 1.0
 **/

class LiftOff implements Runnable {
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }
    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "Liffoff!") + "),";
    }
    @Override
    public void run() {
        while(countDown-- > 0) {
            System.out.print(status());
            Thread.yield(); //终止当前线程
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class T1 {
    static void run(){
        System.out.println("****************run******************");
        for (int i = 0; i < 5; i++) {
            new LiftOff().run();
        }
        System.out.println("\nWaiting for lanuch"); // launch执行完才会执行后面的语句
    }

    static void thread() {
        System.out.println("**************thread********************");
        for (int i = 0; i < 1; i++) {
            new Thread(new LiftOff()).start();
        } // 不同任务的执行在线程被换进换出时混在了一起，每次运行时都有不确定性
        System.out.println("\nWaiting for thread");
    }
    static void single(){
        System.out.println("*****************thread*****************");
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();
    }
    static void cached(){
        System.out.println("**************cached********************");
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        System.out.println("\nWaiting for LiftOff(pool)");
        exec.shutdown();
    }
    static void fixed(){
        System.out.println("*****************fixed*****************");
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            exec.execute(new LiftOff());
        }
        System.out.println("\nWaiting for LiftOff(fixed)");
        exec.shutdown();
    }

    public static void main(String[] args) {
//        run(); // 严格按照次序输出（从0到4，从9到1）
//        thread();
//        single(); // 严格按照次序输出（从0到4，从9到1）
//        cached();
        fixed();
    }
}
