package com.example.juc.mashibing;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Description: 两个线程交替打印
 *
 * @author Linzherong
 * @date 2022/2/19 8:16 下午
 */
public class JucTest3 {
    static volatile boolean flag = false;

    public static void main(String[] args) {
        Object lock = new Object();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                2,
                2,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                new ThreadFactory() {
                    int i = 1;
                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r, "pool-" + i++);
                    }
                });
        pool.execute(()->{
            for (int i = 65; i <= 90 ; i++) {
                synchronized (lock) {
                    if (!flag) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName()+ "=====>" +(char) i);
                    lock.notify();
                    try {
                        if (90 != i) {
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        pool.execute(()->{
            for (int i = 1; i <= 26 ; i++) {
                synchronized (lock) {
                    flag = true;
                    System.out.println(Thread.currentThread().getName()+"=====>" + i);
                    lock.notify();
                    try {
                        if (26 != i) {
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        pool.shutdown();
    }
}
