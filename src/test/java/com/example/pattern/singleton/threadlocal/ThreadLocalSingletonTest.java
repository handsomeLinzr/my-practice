package com.example.pattern.singleton.threadlocal;

import org.junit.jupiter.api.Test;

/**
 * @author LZR
 * @date 2020/12/5-15:40
 */
public class ThreadLocalSingletonTest {

    @Test
    public void testGet() {
        System.out.println("Begin");
        System.out.println(Thread.currentThread().getName() + ":" + ThreadLocalSingleton.getInstance());
        System.out.println(Thread.currentThread().getName() + ":" + ThreadLocalSingleton.getInstance());

        Thread t1 = new Thread(new ThreadExecutor());
        Thread t12= new Thread(new ThreadExecutor());
        t1.start();
        t12.start();

        System.out.println("End");

    }

}
