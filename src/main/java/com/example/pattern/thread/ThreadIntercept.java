package com.example.pattern.thread;

import java.util.concurrent.TimeUnit;

/**
 * 线程停止测试
 */
public class ThreadIntercept {

    private static int i = 1;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            while (!Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println(i);
        });
        thread.start();

        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();  // 将 isInterrupt 设置为 true

    }

}
