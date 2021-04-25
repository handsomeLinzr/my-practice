package com.example.pattern.thread;

import java.util.concurrent.*;

/**
 * 线程创建练习
 */
public class ThreadTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 继承 Thread 的方式
        new A("A-Thread").start();

        // 实现Rennable方式
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ": Runnable 方式实现");
        }, "B-Thread").start();

        // 利用Callable 返回 Future
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> submit = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("开始执行Callable");
                return Thread.currentThread().getName();
            }
        });
        System.out.println(submit.get());
        executorService.shutdown();
    }

    static class A extends Thread {

        public A(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ": Thread 方式实现");
        }
    }

}
