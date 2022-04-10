package com.example.mashibing.juc;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * Description: 总结和巩固阶段
 *
 * @author Linzherong
 * @date 2022/4/10 4:06 下午
 */
public class Last_Test_1 {

    public static void main(String[] args) {
        Last_Test_1 instance = new Last_Test_1();
        instance.p3();
    }

    /**
     * 写一个程序证明AtomXXX类的多个方法并不构成原子性
     * 结果：单个方法是原子的
     */
    private void p1() {
        AtomicLong a = new AtomicLong(1);

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 10; j++) {
                    System.out.println(a.getAndIncrement());
                }
            }).start();
        }
    }

    /**
     * 写一个程序模拟死锁
     */
    private void p2() {
        new Thread(()->{
            m();
        }, "t1").start();
        new Thread(()->{
            m();
        }, "t2").start();
    }

    private void m() {
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * LongAdder
     */
    private void p3() {
        LongAdder longAdder = new LongAdder();
        System.out.println(longAdder.longValue());
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 10; j++) {
                    longAdder.increment();
                    System.out.println(longAdder.longValue());
                }
            }).start();
        }
    }

    /**
     * 拒绝策略
     */
    private void p4() {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                20, 20, 60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100),
                new ThreadFactory() {
                    int i = 0;

                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r, "my-pool-" + i++);
                    }
                },
                // 拒绝策略
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        // 3次重试机会
                        for (int i = 0; i < 3; i++) {
                            if (executor.getQueue().offer(r)){
                                break;
                            }
                        }
                        // 添加日志，后续读取日志操作
                        System.out.println("添加到日志" + r);
                    }
                });


        Executors.newScheduledThreadPool(10);
    }



}
