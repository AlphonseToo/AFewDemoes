package com.zz.chaos.y2022;

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
}
