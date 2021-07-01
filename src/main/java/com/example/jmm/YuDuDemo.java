package com.example.jmm;

import java.util.concurrent.CountDownLatch;

/**
 * Description:
 *
 * @author Linzr
 * @version V2.0.0
 * @date 2021/7/1 3:00 下午
 * @since V2.0.0
 */
public class YuDuDemo {

    private static long count = 1000000000L;

    public static class T {
        private long l1,l2,l3,l4,l5,l6,l7;
        private long x = 0L;
        private long l8,l9,l10,l11,l12,l13,l14;
//        private long y = 0;
    }

    private static T[] ts = new T[2];
    static {
        ts[0] = new T();
        ts[1] = new T();
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);

        Thread t1 = new Thread(() -> {
            for (long i = 0; i < count; i++) {
                ts[0].x = i;
            }
            countDownLatch.countDown();
        });

        Thread t2 = new Thread(() -> {
            for (long i = 0; i < count; i++) {
                ts[1].x = i;
            }
            countDownLatch.countDown();
        });

        long l = System.nanoTime();
        t1.start();
        t2.start();
        countDownLatch.await();
        System.out.println((System.nanoTime() - l)/1000000);

    }

}
