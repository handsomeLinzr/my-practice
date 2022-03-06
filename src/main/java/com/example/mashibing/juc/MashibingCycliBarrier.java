package com.example.mashibing.juc;

import java.util.concurrent.*;

/**
 * Description:
 *
 * @author Linzherong
 * @date 2022/2/18 12:49 下午
 */
public class MashibingCycliBarrier {

    private static final ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10,
            10,
            60,
            TimeUnit.SECONDS,
            new SynchronousQueue<>(),
            new ThreadFactory() {
                int i = 0;
                @Override
                public Thread newThread(Runnable r) {
                    return new Thread(r, "my-pool-"+i++ );
                }
            });

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, ()-> System.out.println(Thread.currentThread().getName()+"======>整合完成"));
        for (int i = 0; i < 6; i++) {
            threadPool.execute(() -> {
                System.out.println("线程执行整合===>" + Thread.currentThread().getName());
                try {
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("线程执行整合后续===>" + Thread.currentThread().getName());
            });
        }
        threadPool.shutdown();
    }

}
