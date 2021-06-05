package com.example.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.LongStream;

/**
 * @author Administrator
 */
public class ForkJoinDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int length = 120000000;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE);
        }
        System.out.println(calculateSingleThread(arr));
        System.out.println(calculateThreadPool(arr));
        System.out.println(calculateForkJoinPool(arr));
    }

    // 单线程
    private static long calculateSingleThread(int[] arr) {
        long sum = 0;
        long start = System.currentTimeMillis();
        for (int i : arr) {
            sum += i/3*3/3*3/3*3/3*3/3*3;
        }
        System.out.println(System.currentTimeMillis() - start);
        return sum;
    }

    // 多线程
    private static long calculateThreadPool(int[] arr) throws ExecutionException, InterruptedException {
        int n = Runtime.getRuntime().availableProcessors();
        System.out.println("核心数 " + n);
        ExecutorService executorService = Executors.newFixedThreadPool(n);

        long start = System.currentTimeMillis();
        List<Future<Long>> futureList = new ArrayList<>(n);
        int park = arr.length / n;
        for (int i = 0; i < n; i++) {
            int num = i;
            Future<Long> submit = executorService.submit(new Callable<Long>() {
                long sum;
                @Override
                public Long call() throws Exception {
                    for (int j = num * park; j < park * (num + 1); j++) {
                        sum += arr[j]/3*3/3*3/3*3/3*3/3*3;
                    }
                    return sum;
                }
            });
            futureList.add(submit);
        }
        long sum = 0;
        for (Future<Long> future : futureList) {
            sum += future.get();
        }
        System.out.println(System.currentTimeMillis() - start);
        executorService.shutdown();
        return sum;
    }

    // fork join 分治
    private static long calculateForkJoinPool(int[] arr) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        ForkJoinTask<Long> submit = forkJoinPool.submit(new SumTask(arr, 0, arr.length));
        Long sum = submit.get();
        System.out.println(System.currentTimeMillis() - start);
        return sum;
    }
    // 定义一个继承了 RecursiveTask 的类
    private static class SumTask extends RecursiveTask<Long> {
        private int[] arr;
        private int from;
        private int to;
        public SumTask(int[] arr, int from, int to) {
            this.arr = arr;
            this.from = from;
            this.to = to;
        }
        @Override
        protected Long compute() {
            // 拆分成一个一个的不大于1000个数相加的子任务
            long sum = 0;
            if (to - from <= 1000) {
                // 小于等于1000，则直接计算
                for (int i = from; i < to; i++) {
                    sum += arr[i]/3*3/3*3/3*3/3*3/3*3;
                }
            } else {
                int middle = (from + to) >>> 1;
                SumTask leftTask = new SumTask(arr, from, middle);
                SumTask rightTask = new SumTask(arr, middle, to);
                leftTask.fork();
                Long right = rightTask.compute();
                sum =  leftTask.join() + right;
            }
            return sum;
        }
    }

}
