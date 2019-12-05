package com.thinking.demo.chapter21;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Callable中的call()方法和Runnable中的run()方法
 * call可以返回一个值，用submit来调用该任务，把返回结果封装在Future<?>中，</>run不能返回任何值
 *
 * @author Alphonse
 * @date 2019/12/2 15:13
 * @since 1.0
 **/

class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result of TaskWithResult " + id;
    }
}

public class T2 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            results.add(exec.submit(new TaskWithResult(i)));
        }
        for(Future<String> fs : results) {
            try{
                System.out.println(fs.get());
            }catch (Exception e) {
                System.out.println(e);
            }finally {
                exec.shutdown();
            }
        }
    }
}

class SimplePriorities implements Runnable {
    private int countDown = 5;
    private volatile double d;
    private int priority;

    public SimplePriorities(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "SimplePriorities{Thread: " +
                Thread.currentThread() +
                "countDown=" + countDown +
                '}';
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        while(true){
            for (int i = 0; i < 100000; i++) {
                d += (Math.PI + Math.E) / (double)i;
                if(i % 1000 == 0)
                    Thread.yield();
            }
            System.out.println(this);
            if(--countDown == 0) return;
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 1; i++) {
            exec.execute(new SimplePriorities(Thread.MIN_PRIORITY));
        }
        exec.shutdown();
    }
}
