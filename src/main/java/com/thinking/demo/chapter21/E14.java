package com.thinking.demo.chapter21;

import java.util.Timer;
import java.util.TimerTask;

/**
 * ****
 *
 * @author Alphonse
 * @date 2019/12/3 10:05
 * @since 1.0
 **/

class Task extends TimerTask{
    private static int count = 0;
    @Override
    public void run() {
        System.out.println("运行：" + count++);
    }
}

class TimerGenerator{
    private static Timer timer = new Timer();
    private TimerTask tt;
    private long ms;

    public TimerGenerator(TimerTask tt, long ms) {
        this.tt = tt;
        this.ms = ms;
    }

    public Timer next() {
        timer.schedule(tt, ms);
        return timer;
    }
}
public class E14 {
    public static void main(String[] args) throws Exception{
        if(args.length < 1){
            System.err.println("没有参数");
        }
        int numOfTimers = Integer.valueOf(args[0]);
        System.out.println(numOfTimers);
        for (int i = 0; i < numOfTimers; i++) {
            new Timer().schedule(new Task(), numOfTimers-i);
        }
        Thread.sleep(2*numOfTimers);
        System.exit(0);
    }
}
