package com.example.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo implements Callable{

    public static void main(String[] args) {

        FutureTask<String> futureTask = new FutureTask<String>(new CallableDemo());
        for (int i = 0; i < 10; i++) {
            new Thread(futureTask).start();
            String result = null;
            try {
                result = futureTask.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println(result);
        }

    }

    @Override
    public Object call() throws Exception {
        return Thread.currentThread().getName() + "  hello futureTask";
    }
}
