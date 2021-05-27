package com.example.block;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class BlockQueueDemo {

    public static void main(String[] args) throws InterruptedException {
//        UserService userService = new UserService();
//        User azhe = userService.register("azhe");
//        System.out.println(azhe);
//
//        User danrong = userService.register("DANRONG");
//        System.out.println(danrong);

        MyBlockQueue<String> queue = new MyBlockQueue<>(5);

        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                while (!Thread.currentThread().isInterrupted()) {
                    String take = null;
                    take = queue.take();
                    System.out.println(take);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();

        queue.put("1");
        System.out.println("放入1");
        queue.put("2");
        System.out.println("放入2");
        queue.put("3");
        System.out.println("放入3");
        queue.put("4");
        System.out.println("放入4");
        queue.put("5");
        System.out.println("放入5");
        queue.put("6");
        System.out.println("放入6");
        queue.put("7");
        System.out.println("放入7");

        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.getAndIncrement();

    }
}
