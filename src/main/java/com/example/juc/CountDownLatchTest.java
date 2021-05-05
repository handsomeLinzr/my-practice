package com.example.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest extends Thread{

    private CountDownLatch countDownLatch;

    public CountDownLatchTest(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < 10; i++) {
            new CountDownLatchTest(countDownLatch).start();
        }
        System.out.println("预备备！");
        System.out.println("冲鸭！");
        countDownLatch.countDown();
//        System.out.println();
//        for (int i = 0; i < 5; i++) {
//            new CountDownLatchTest(countDownLatch).start();
//        }
//        countDownLatch.await();
//        System.out.println("执行");
    }

    @Override
    public void run() {
//        System.out.println(Thread.currentThread().getName() + " 准备完毕");
//        countDownLatch.countDown();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 冲鸭！！！");
    }
}
