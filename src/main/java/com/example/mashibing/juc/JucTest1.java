package com.example.mashibing.juc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

/**
 * Description:
 * 1.一个容器  add size
 * 线程1添加10个元素，线程2监控，5个提示并结束
 *
 * 2.固定容器同步容器  put get   getCount  两个生产者线程   10个消费者线程阻塞调用
 *
 * @author Linzherong
 * @date 2022/2/19 3:13 下午
 */
public class JucTest1 {

    static Thread t1 = null;
    static Thread t2 = null;

    @Override
    protected void finalize() throws Throwable {
        System.out.println("gc");
        super.finalize();
    }

    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 10, 10, TimeUnit.SECONDS, new SynchronousQueue<>(), (ThreadFactory) Thread::new);
        MyContain<Integer> contain = new MyContain<>();
        // 同步队列
        List<String> list = Collections.synchronizedList(new ArrayList<>());

        // countDownLatch
//        {
//            CountDownLatch addLatch = new CountDownLatch(1);
//            CountDownLatch sizeLatch = new CountDownLatch(1);
//            pool.execute(() -> {
//                for (int i = 0; i < 10; i++) {
//                    contain.add(i);
//                    System.out.println(i);
//                    if (contain.size() == 5) {
//                        sizeLatch.countDown();
//                        try {
//                            addLatch.await();
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            });
//            pool.execute(() -> {
//                try {
//                    sizeLatch.await();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("5个了 ====》" + contain.size());
//                addLatch.countDown();
//            });
//            pool.shutdown();
//        }
//
//        // LockSupport
//        {
//            t1 = new Thread(() -> {
//                for (int i = 0; i < 10; i++) {
//                    contain.add(i);
//                    System.out.println(i);
//                    if (5 == contain.size()) {
//                        LockSupport.unpark(t2);
//                        LockSupport.park();
//                    }
//                }
//            });
//
//            t2 = new Thread(()->{
//                LockSupport.park();
//                System.out.println("到了=======》" + contain.size());
//                LockSupport.unpark(t1);
//            });
//
//            t1.start();
//            t2.start();
//        }

        // wati notify
        {
            // 锁
            Object lock = new Object();

            pool.execute(()->{
                for (int i = 0; i < 10; i++) {
                    synchronized (lock) {
                        contain.add(i);
                        System.out.println(i);
                        if (5 == contain.size()) {
                            lock.notify();
                            try {
                                lock.wait();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            });

            pool.execute(()->{
                synchronized (lock) {
                    try {
                        if (5 != contain.size()) {
                            lock.wait();
                        }
                        System.out.println("到了=====》" + contain.size());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    lock.notify();
                }
            });

            pool.shutdown();

        }



    }

    /**
     * 自定义容器
     * @param <T>
     */
    static class MyContain<T> extends ArrayList<T> {
        @Override
        public boolean add(T t) {
            return super.add(t);
        }

        @Override
        public int size() {
            return super.size();
        }
    }

}
