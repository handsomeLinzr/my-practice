package com.example.redis;

import java.util.concurrent.TimeUnit;

public class DistributeLockDemo implements Runnable{

    @Override
    public void run() {
        DistributeLock distributeLock = new DistributeLock();
        while (true) {
            String lock = distributeLock.acquireLock("order", 2000, 3000);
            if (lock != null) {
                System.out.println(Thread.currentThread().getName() + "————> 获得了锁");
                try {
                    TimeUnit.SECONDS.sleep(2);
                    if (distributeLock.releaseLock("order", lock)) {
                        System.out.println(Thread.currentThread().getName() + "————> 释放了锁");
                    }
                    break;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        // 10个线程争一个分布式锁
        for (int i = 0; i < 10; i++) {
            new Thread(new DistributeLockDemo(), "get-lock-" + i).start();
        }
    }

}
