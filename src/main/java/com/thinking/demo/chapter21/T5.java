package com.thinking.demo.chapter21;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 线程状态：新建-就绪-阻塞-死亡
 *
 * @author Alphonse
 * @date 2019/12/3 15:06
 * @since 1.0
 **/

class Chopstick{
    private boolean taken = false;
    public synchronized void take() throws InterruptedException {
        while(taken)
            wait();
        taken = true;
    }
    public synchronized void drop() {
        taken = false;
        notifyAll();
    }
}
class Philosopher implements Runnable {
    private Chopstick left;
    private Chopstick right;
    private final int id;
    private final int ponderFactor;
    private Random rand = new Random(47);
    private void pause() throws InterruptedException {
        if(ponderFactor == 0) return;
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(ponderFactor*250));
    }

    public Philosopher(Chopstick left, Chopstick right, int id, int ponderFactor) {
        this.left = left;
        this.right = right;
        this.id = id;
        this.ponderFactor = ponderFactor;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                System.out.println(this + " " + "thinking");
                pause();
                System.out.println(this + " " + "grabbing right");
                right.take();
                System.out.println(this + " " + "grabbing left");
                left.take();
                System.out.println(this + " " + "eating");
                pause();
                right.drop();
                left.drop();
            }
        }catch (Exception e) {
            System.out.println(this + " " + "exiting via interrupt");
        }
    }
    public String toString() {
        return "Philosopher " + id;
    }
}

class DeadlockingDiningPhilosophers {
    public static void main(String[] args) throws Exception {
        int ponder = 5;
        if(args.length > 0)
            ponder = Integer.parseInt(args[0]);
        int size = 5;
        if(args.length > 1)
            size = Integer.parseInt(args[1]);
        ExecutorService exec = Executors.newCachedThreadPool();
        Chopstick[] sticks = new Chopstick[size];
        for (int i = 0; i < size; i++) {
            sticks[i] = new Chopstick();
        }
        /**
         * 死锁发生的条件：
         * 互斥条件；
         * 至少有一个任务它必须持有一个资源且正在等待获取一个当前被别的任务持有的资源；
         * 资源不能被任务抢占；
         * 必须有循环等待。
         * 设置一个人先左手拿筷子，再右手拿筷子，就会破坏掉循环等待的条件，从而破坏循环等待
         * 练习31，题目中没有明确说明哲学家拿筷子的方式，如果一次同时拿2根筷子，只有一根筷子的情况下不取，则不会发生死锁
         * 如果哲学家拿两根筷子有先后顺序，则筷子总数为奇数的情况下且筷子总数不大于哲学家的人数则有可能发生死锁
         */
        for (int i = 0; i < size; i++) {
            if(i < size-1)
                exec.execute(new Philosopher(sticks[i], sticks[(i+1)%size], i, ponder));
            else
                exec.execute(new Philosopher(sticks[0], sticks[i], i, ponder));
        }
        if(args.length == 3 && args[2].equals("timeout"))
            TimeUnit.SECONDS.sleep(5);
        else {
            System.out.println("Press 'Enter' to quit");
            System.in.read();
        }
    }
}

public class T5 {
    public static void main(String[] args) throws InterruptedException {
//        CountDownLatch ls = new CountDownLatch(10);
//        ls.await();
//        ls.countDown();
//        Thread.currentThread().setPriority(10);

        ThreadLocal<Integer> value = new ThreadLocal<>();
        value.set(5);
        System.out.println(value.get());
        value.remove();
        System.out.println(value.get());
    }
}
