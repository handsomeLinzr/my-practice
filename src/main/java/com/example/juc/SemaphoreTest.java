package com.example.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest extends Thread{

    private Semaphore semaphore;
    private int num;

    public SemaphoreTest(Semaphore semaphore, int num) {
        this.semaphore = semaphore;
        this.num = num;
    }

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);  // 5个车位
        for (int i = 1; i <= 10; i++) {
            new SemaphoreTest(semaphore, i).start();
        }
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();  // 抢令牌
            System.out.println("第" + num + "：我抢到了车位！");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("第" + num + ": 我先走了");
            semaphore.release();  // 释放令牌
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
