package com.example.juc.mashibing;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description: 两个线程交替打印
 *
 * @author Linzherong
 * @date 2022/3/1 12:13 上午
 */
public class MashibingJiaotiOutput {

    static Thread t1, t2;
    static volatile Boolean flag = false;
    enum RUN_THREAD {T1,T2}
    static volatile RUN_THREAD runThread = RUN_THREAD.T1;
    public static void main(String[] args) {
        casHandler();
    }

    /**
     * synchronized处理
     */
    private static void synchronizedHandler() {
        Object obj = new Object();
        t1 = new Thread(()->{
            synchronized (obj) {
                flag = true;
                for (int i = 1; i < 27; i++) {
                    System.out.printf("%s=====>%s\n", Thread.currentThread().getName(), i);
                    obj.notify();
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                obj.notify();
            }
        }, "t1");

        t2 = new Thread(()->{
            synchronized (obj) {
                while (!flag) {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 65; i <91; i++) {
                    System.out.printf("%s=====>%s\n", Thread.currentThread().getName(), (char)i);
                    obj.notify();
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "t2");
        t2.start();
        t1.start();
    }

    /**
     * LockSupport 解决方法
     */
    private static void lockSupportHandler() {
        t1 = new Thread(()->{
            for (int i = 1; i < 27; i++) {
                System.out.printf("%s========>%s\n", Thread.currentThread().getName(), i);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        }, "t1");
        t2 = new Thread(()->{
            for (int i = 65; i <91; i++) {
                LockSupport.park();
                System.out.printf("%s=====>%s\n", Thread.currentThread().getName(), (char)i);
                LockSupport.unpark(t1);
            }
        }, "t2");
        t1.start();
        t2.start();
    }

    /**
     * ReentrantLock 解决方法
     */
    private static void reentrantLockHandler() {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        t1 = new Thread(()->{
            try {
                lock.lock();
                flag = true;
                for (int i = 1; i < 27; i++) {
                    System.out.printf("%s========>%s\n", Thread.currentThread().getName(), i);
                    condition.signal();
                    condition.await();
                }
                condition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t1");
        t2 = new Thread(()->{
            try {
                lock.lock();
                while (!flag) {
                    condition.await();
                }
                for (int i = 65; i <91; i++) {
                    System.out.printf("%s=====>%s\n", Thread.currentThread().getName(), (char)i);
                    condition.signal();
                    condition.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t2");
        t1.start();
        t2.start();
    }

    /**
     * 双condition处理
     */
    private static void doubleConditionHandler() {
        Lock lock = new ReentrantLock();
        Condition T1 = lock.newCondition();
        Condition T2 = lock.newCondition();
        t1 = new Thread(()->{
            try {
                lock.lock();
                flag = true;
                for (int i = 1; i < 27; i++) {
                    System.out.printf("%s========>%s\n", Thread.currentThread().getName(), i);
                    T2.signal(); // 唤醒T2的等待队列
                    T1.await();  // 排在T1的等待队列中
                }
                T2.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t1");
        t2 = new Thread(()->{
            try {
                lock.lock();
                while (!flag) {
                    T2.await();
                }
                for (int i = 65; i <91; i++) {
                    System.out.printf("%s=====>%s\n", Thread.currentThread().getName(), (char)i);
                    T1.signal();
                    T2.await();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t2");
        t1.start();
        t2.start();
    }

    /**
     * 阻塞队列的解决方式
     */
    private static void queueHandler() {
        SynchronousQueue<String> queue = new SynchronousQueue<>();
        t1 = new Thread(()->{
            try {
                for (int i = 1; i < 27; i++) {
                    System.out.printf("%s========>%s\n", Thread.currentThread().getName(), i);
                    queue.put("");
                    queue.take();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");
        t2 = new Thread(()->{
            try {
                for (int i = 65; i < 91; i++) {
                    queue.take();
                    System.out.printf("%s=====>%s\n", Thread.currentThread().getName(), (char) i);
                    queue.put("");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2");
        t1.start();
        t2.start();
    }

    /**
     * CAS方式解决
     */
    private static void casHandler() {
        t1 = new Thread(()->{
            for (int i = 1; i < 27; i++) {
                while (RUN_THREAD.T2.equals(runThread)) {}
                System.out.printf("%s========>%s\n", Thread.currentThread().getName(), i);
                runThread = RUN_THREAD.T2;
            }
        }, "t1");
        t2 = new Thread(()->{
            for (int i = 65; i < 91; i++) {
                while (RUN_THREAD.T1.equals(runThread)) {}
                System.out.printf("%s=====>%s\n", Thread.currentThread().getName(), (char) i);
                runThread = RUN_THREAD.T1;
            }
        }, "t2");
        t1.start();
        t2.start();
    }


}
