package com.thinking.demo.chapter21;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/12/4 10:15
 * @since 1.0
 **/
class MySleep implements Runnable{
    private static Random rand = new Random(45);
    private int i;

    public MySleep(int i) {
        this.i = i;
    }

    @Override
    public void run(){
        System.out.println("Go to sleep: " + i);
        try{
            TimeUnit.SECONDS.sleep(rand.nextInt(10) + 1L);
        }catch (Exception e) {
            System.out.println("failed: " + i);
        }
        System.out.println("Sleep over: " + i);
    }
}
public class E6 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(5);
        try{
            for (int i = 0; i < 5; i++) {
                exec.execute(new MySleep(i));
            }
        }catch (Exception e) {
            System.out.println(e);
        }
        exec.shutdown();
    }
}
