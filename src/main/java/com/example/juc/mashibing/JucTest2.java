package com.example.juc.mashibing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 * 2.面试题：一个固定容量同步容器,支持阻塞调用  put/get/getCount   2生产者10消费者阻塞使用
 *
 * @author Linzherong
 * @date 2022/2/19 7:03 下午
 */
public class JucTest2 {
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                100,
                100,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100),
                new ThreadFactory() {
                    int i = 1;
                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r, "pool-" + i++);
                    }
                });
        MySynchronizedList<String> list = new MySynchronizedList<>(5);

        for (int i = 0; i < 10; i++) {
            pool.execute(()->{
                System.out.println("获取=============》"+list.get());
            });
        }
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 10; i++) {
            pool.execute(()->{
                list.put("插入===========>"+Thread.currentThread().getName());
                System.out.println("输入插入" + Thread.currentThread().getName());
            });
        }
        pool.shutdown();

    }
}

/**
 * 自定义同步容器
 * @param <T>
 */
class MySynchronizedList<T> extends ArrayList<T> {

    private final LinkedList<T> list;
    private final int maxSize;
    private final ReentrantLock lock = new ReentrantLock();
    Condition provider = lock.newCondition();
    Condition consumer = lock.newCondition();
    public MySynchronizedList(int size) {
        this.list = new LinkedList<>();
        this.maxSize = size;
    }

    public void put(T t) {
        try {
            lock.lock();
            while (list.size() >= maxSize) {
                provider.await();
            }
            list.add(t);
            consumer.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public T get() {
        T t = null;
        try {
            lock.lock();
            while (list.size() <= 0) {
                consumer.await();
            }
            t = list.removeFirst();
            provider.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return t;
    }

    public int getCount() {
        return list.size();
    }

}
