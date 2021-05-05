package com.example.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ConditionSignal implements Runnable{

    private Lock lock;
    private Condition condition;

    public ConditionSignal(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            System.out.println("notify thread start------------------");
            condition.signal();
            System.out.println("notify thread end------------------");
        } finally {
            lock.unlock();
        }
    }
}
