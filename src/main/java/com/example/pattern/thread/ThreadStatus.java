package com.example.pattern.thread;

import java.util.concurrent.TimeUnit;

/**
 * 线程状态测试
 */
public class ThreadStatus {

    public static void main(String[] args) {
        // TIMED_WAITING
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "time_waiting_thread").start();

        // WAITING
        new Thread(()->{
            synchronized (String.class) {
                try {
                    String.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "waiting_thread").start();

        new Thread(new BlockStatus(), "block_time_waiting_thread_a").start();
        new Thread(new BlockStatus(), "block_thread_b").start();

    }

    static class BlockStatus implements Runnable {
        @Override
        public void run() {
            synchronized (ThreadStatus.class) {
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
