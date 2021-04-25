package com.example.pattern.thread;

import java.util.concurrent.TimeUnit;

/**
 * 重置标志位
 */
public class ThreadReset {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
           while (true) {
               if (Thread.currentThread().isInterrupted()) {  // 默认false
                   System.out.println(Thread.currentThread().isInterrupted());
                   Thread.interrupted(); // 复位，重写又设置为 false
                   System.out.println(Thread.currentThread().isInterrupted());
               }
           }
        });
        thread.start();

        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
        System.out.println(Thread.currentThread().getName() + ":" + thread.isInterrupted());
    }
}
