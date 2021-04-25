package com.example.pattern.thread;

import java.util.concurrent.TimeUnit;

/**
 * 阻塞方法会抛出异常测试
 */
public class ThreadExceptionDemo {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("demo");
                } catch (InterruptedException e) {
                    break;
//                    e.printStackTrace();
                }
            }
        });
        thread.start();

        thread.interrupt();
        System.out.println(thread.isInterrupted());
    }
}
