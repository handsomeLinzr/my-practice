package com.example.mashibing.juc;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author Linzherong
 * @date 2022/2/21 12:49 下午
 */
public class MashibingThreadLocal {

    public static void main(String[] args) {
        ThreadLocal<Person> threadLocal = new ThreadLocal<>();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadLocal.get());
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Person p = new Person();
            p.setName("李四");
            threadLocal.set(p);
            System.out.println(threadLocal.get().getName());
            threadLocal.remove(); // 防止内存泄漏
        }).start();
    }

    static class Person {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}

