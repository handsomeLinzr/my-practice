package com.example.block;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 自定义阻塞队列
 */
public class MyBlockQueue<E> {

    private final Lock lock;
    private final Condition notFull;
    private final Condition notEmpty;
    private int size;
    private AtomicInteger count = new AtomicInteger();


    public MyBlockQueue(int size) {
        this.size = size;
        table = new Object[size];
        lock = new ReentrantLock();
        notFull = lock.newCondition();
        notEmpty = lock.newCondition();
    }
    private java.lang.Object[] table;
    private int putIndex;  // 下一次放的指针
    private int takeIndex;  // 下一次拿的指针

    /**
     * 获取数据
     * @return
     */
    public E take() throws InterruptedException {
        // 获得锁
        lock.lockInterruptibly();
        try {
            while (count.intValue() == 0) {  // 没有数据
                notEmpty.await();  // 阻塞
            }
            count.decrementAndGet();  // count-1
            E e =  (E)table[takeIndex++];  // 获得数据
            table[takeIndex++] = null;  // 移除
            takeIndex = takeIndex == size ? 0 : takeIndex;  // 设置下个获取的指针
            notFull.signal();
            return e;
        } finally {
            lock.unlock();
        }
    }

    /**
     * 添加数据
     * @param e
     */
    public void put(E e) throws InterruptedException {
        lock.lockInterruptibly();
        try {
            while (count.intValue() == size) {
                notFull.await();
            }
            count.incrementAndGet();  // count +1
            table[putIndex++] = e;
            putIndex = putIndex == size? 0 : putIndex;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

}
