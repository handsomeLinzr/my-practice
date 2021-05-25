package com.example.juc;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {

    public static void main(String[] args) throws Exception {

        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Thread thread1 = new Thread(new ConditionAwait(lock, condition));
        Thread thread2 = new Thread(new ConditionAwait(lock, condition));
//        Thread thread2 = new Thread(new ConditionSignal(lock, condition));
//        Thread thread = new Thread(() -> {
//            int i = 1;
//            while (i++ < 999999) {
//                System.out.println("1");
//            }
//        });
        thread1.start();
        thread2.start();
//        thread.start();

        TimeUnit.SECONDS.sleep(1);
//        thread.interrupt();

    }
}
