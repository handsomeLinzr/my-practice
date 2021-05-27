package com.example.block;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PointService {

    private static MyBlockQueue<User> queue = new MyBlockQueue(16);
    static ExecutorService executor = Executors.newSingleThreadExecutor();

    static {
        init();
    }

    public static void init() {
        executor.execute(()->{
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    User user = queue.take();
                    user.setPoint(200L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void addUser(User user) {
        try {
            queue.put(user);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
