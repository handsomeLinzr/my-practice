package com.example.pattern.singleton.threadlocal;

/**
 * @author LZR
 * @date 2020/12/5-15:53
 */
public class ThreadExecutor implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":" + ThreadLocalSingleton.getInstance());
        System.out.println(Thread.currentThread().getName() + ":" + ThreadLocalSingleton.getInstance());
        System.out.println(Thread.currentThread().getName() + ":" + ThreadLocalSingleton.getInstance());
        System.out.println(Thread.currentThread().getName() + ":" + ThreadLocalSingleton.getInstance());
    }
}
