package com.example.juc.mashibing;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 *
 * @author Linzherong
 * @date 2022/2/18 5:54 下午
 */
public class MashibingPhaser {

    public static final ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), new ThreadFactory() {
        int i = 0;
        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "my-pool-" +i++);
        }
    });

    public static void main(String[] args) {
        Phaser phaser = new Phaser(5) {
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                switch (phase) {
                    case 0:
                        System.out.println("人到齐了====》" + registeredParties);
                        return false;
                    case 1:
                        System.out.println("午饭结束====》" + registeredParties);
                        return true;
                    case 2:
                        System.out.println("客人走了====》" + registeredParties);
                        return true;
                    default:
                        return true;
                }
            }
        };

        for (int i = 0; i < 3; i++) {
            executor.execute(()->{
                System.out.println(Thread.currentThread().getName() + "=========>到了");
                phaser.arriveAndAwaitAdvance();
                System.out.println(Thread.currentThread().getName() + "===>婚礼开始");
                sleep();
                System.out.println(Thread.currentThread().getName() + "===>吃午饭");
                sleep();
                System.out.println(Thread.currentThread().getName() + "===>午饭吃饱");
                phaser.arriveAndDeregister();
                System.out.println(Thread.currentThread().getName() + "===>回家");
            });
        }
        executor.execute(()->{
            System.out.println("新娘到了");
            phaser.arriveAndAwaitAdvance();
            System.out.println(Thread.currentThread().getName() + "=>开始结婚了");
            sleep();
            System.out.println("吃饭");
            sleep();
            phaser.arriveAndAwaitAdvance();
            System.out.println("送客");
            sleep();
            phaser.arriveAndAwaitAdvance();
            System.out.println("入洞房");
        });
        executor.execute(()->{
            System.out.println("新郎到了");
            phaser.arriveAndAwaitAdvance();
            System.out.println(Thread.currentThread().getName() + "=>开始结婚了");
            sleep();
            System.out.println("吃饭");
            sleep();
            phaser.arriveAndAwaitAdvance();
            System.out.println("送客");
            sleep();
            phaser.arriveAndAwaitAdvance();
            System.out.println("入洞房");
        });

        executor.shutdown();
    }

    private static void sleep() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
