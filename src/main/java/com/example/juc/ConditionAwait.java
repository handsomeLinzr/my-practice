package com.example.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ConditionAwait implements Runnable{
    private Lock lock;
    private Condition condition;

    public ConditionAwait(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            System.out.println("await thread start------------------");
            condition.await();
            System.out.println("await thread end------------------");
            int i = -100;
            while (i++ < 999999) {
                System.out.println("1");
                if (Thread.interrupted()) {
                    System.out.println("true");
                    break;
                }
            }
            System.out.println(Thread.interrupted());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
