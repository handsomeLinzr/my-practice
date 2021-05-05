package com.example.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

public class ReentrantLockTest {

    private int a = 0;
    private Lock lock = new ReentrantLock();
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();  // 读写锁
    private Lock rLock = rwLock.readLock();  // 读锁
    private Lock wLock = rwLock.writeLock();  // 写锁
    private StampedLock stampedLock = new StampedLock();

    public static void main(String[] args) {
//        try {
//            testLock();
//        } catch (InterruptedException e) {
//            e.getStackTrace();
//        }
        testRWLock();
    }
    public StampedLock getStampedLock() {
        return this.getStampedLock();
    }

    /**
     * 读写锁的自增
     */
    public void wIncr() {
        wLock.lock();  //
        try {
            a ++;
        } finally {
            wLock.unlock();
        }
    }
    /**
     * 读写锁的获取
     */
    public int rGetA() {
        rLock.lock();
        try {
            return a;
        } finally {
            rLock.unlock();
        }
    }

    /**
     * 重入锁的自增
     */
    public void incr() {
        this.lock.lock();
        try {
            a ++;
        } finally {
            lock.unlock();
        }
    }
    public int getA() {
        return a;
    }

    public static void testLock() throws InterruptedException {
        ReentrantLockTest test = new ReentrantLockTest();
        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
                test.incr();
            }).start();
        }
        TimeUnit.SECONDS.sleep(3);
        System.out.println(test.getA());
    }

    public static void testRWLock() {
        ReentrantLockTest test = new ReentrantLockTest();
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(test.rGetA());
            }).start();
        }
        new Thread(()->{
            test.wIncr();
        }).start();
        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                System.out.println(test.rGetA());
            }).start();
        }
    }
}
