package com.example.thread;

public class ThreadLocalDemo {

    private static int num = 5;
    static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);
    public Integer get() {
        return threadLocal.get();
    }
    public void put(Integer integer) {
        threadLocal.set(integer);
    }

    public static void main(String[] args) {
//        threadWithOutLocal();
//        threadWithLocal();
//        withThreadLocal();
        magicHashCode(16);
        magicHashCode(32);
    }

    // 没有ThreadlLocal的情况下，数据不能控制
    private static void threadWithOutLocal() {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(()->{
                num += 5;
                System.out.println(Thread.currentThread().getName() + ":" + num);
            }, "thread" + (i+1));
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }

    // 每个都拿到一个对象的情况
    private static void threadWithLocal() {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(()->{
                ThreadLocalDemo threadLocalDemo = new ThreadLocalDemo();
                Integer integer = threadLocalDemo.get();
                threadLocalDemo.put(integer + 5);
                System.out.println(Thread.currentThread().getName() + ":" + threadLocalDemo.get());
            }, "thread" + (i+1));
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }

    private static void withThreadLocal() {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(()->{
                Integer value = threadLocal.get();
                value += 5;
                threadLocal.set(value);
                System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());
            });
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }

    private static void magicHashCode(int size) {
        int HASH_INCREMENT = 0x61c88647;
        int code = 0;
        for (int i = 0; i < size; i++) {
            System.out.print((code & (size-1)) + " ");
            code += HASH_INCREMENT;
        }
        System.out.println();
    }

}
