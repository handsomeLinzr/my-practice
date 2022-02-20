package com.example.juc.mashibing;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Description:
 *
 * @author Linzherong
 * @date 2022/2/19 12:39 上午
 */
public class MashibingSemaphore {

    public static final ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), new ThreadFactory() {
        int i = 0;
        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "my-pool-" +i++);
        }
    });
    private static final Random random = new Random();

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 20; i++) {
            executor.execute(()->{
                try {
                    semaphore.acquire();
                    System.out.println("车==》" + Thread.currentThread().getName() + "==》停车");
                    sleep();
                    System.out.println("开走");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            });
        }
        executor.shutdown();
    }

    private static void sleep() {
        try {
            TimeUnit.SECONDS.sleep(random.nextInt(5));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
