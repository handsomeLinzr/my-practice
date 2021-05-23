package com.example.thread;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Demo {
//    private static int i = 0;
    public static volatile boolean stop = false;

    public static void main(String[] args) throws InterruptedException {
//        Demo demo1 = new Demo();
//        Demo demo2 = new Demo();
//        new Thread(demo1).start();
//        new Thread(demo2).start();  // 这种情况锁为类信息，锁粒度加大，会互斥

//        Object lock = new Object();
//        new Thread(new ThreadA(lock)).start();
//        new Thread(new ThreadB(lock)).start();

        // 加 volatile 能让线程停  volatile原则
        Thread thread = new Thread(()->{
            int i = 0;
            while (!stop) {
                i++;
            }
            System.out.println(i);
        });
        thread.start();
        Thread.sleep(1000);
        stop = true;

//        Thread threadA = new Thread(() -> {  // 锁原则
//            synchronized (Demo.class) {
//                i = 10;
//            }
//        });
//        Thread threadB = new Thread(() -> {
//            synchronized (Demo.class) {
//                System.out.println(i);
//            }
//        });
//        threadA.start();
//        threadB.start();

//        Thread thread = new Thread(()->{  // start原则
//            System.out.println(i);
//        });
//        i = 100;
//        thread.start();
    }
}
