package com.example.thread;

import java.util.concurrent.*;

/**
 * Description: 线程池练习
 *
 * @author Linzr
 * @version V2.0.0
 * @date 2021/5/25 11:46 上午
 * @since V2.0.0
 */
public class ThreadPoolDemo {

    public static void main(String[] args) throws InterruptedException {
//        ExecutorService service = Executors.newFixedThreadPool(3);  // 固定
        ExecutorService service = Executors.newSingleThreadExecutor(); // 单线程
//        ExecutorService service = Executors.newCachedThreadPool();  // 可调整
//        ScheduledExecutorService service = Executors.newScheduledThreadPool(3);  // 定时任务
        for (int i = 0; i < 30; i++) {
            service.execute(()->{
                System.out.println(Thread.currentThread().getName() + "-------");
            });
//            service.schedule(()->{
//                System.out.println(Thread.currentThread().getName() + "----");
//            }, 5L, TimeUnit.SECONDS);  // 延时执行
        }
        TimeUnit.SECONDS.sleep(5);
        service.shutdown();
        System.out.println(~1);

    }


}
