package com.example.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Description:
 *
 * @author Linzr
 * @version V2.0.0
 * @date 2021/6/2 2:37 下午
 * @since V2.0.0
 */
public class ForkJoinDemo {

    public static void main(String[] args) throws Exception{

        int length = 120000000;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE);
        }
        long start1 = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        ForkJoinTask<Long> result = forkJoinPool.submit(new AddRecursiveTask(arr, 0, length));
        Long sum1 = result.get();
        System.out.println("耗时：" + (System.currentTimeMillis() - start1) + " 结果："+sum1);

        long start2 = System.currentTimeMillis();
        long sum2 = 0;
        for (int i = 0; i < length; i++) {
            sum2 += arr[i]*3/3*3/3*3/3*3/3*3/3*3/3;
        }
        System.out.println("耗时：" + (System.currentTimeMillis() - start2) + " 结果："+sum2);

        long start3 = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(12);
        int park = length / 12;
        long sum3 = 0;
        List<Future<Long>> resultList = new ArrayList<>(12);
        for (int i = 0; i < 12; i++) {
            int index = i;
            resultList.add(executorService.submit(new Callable<Long>() {
                @Override
                public Long call() throws Exception {
                    long sum = 0;
                    for (int j = index * park; j < (index+1) * park; j++) {
                        sum += arr[j]*3/3*3/3*3/3*3/3*3/3*3/3;
                    }
                    return sum;
                }
            }));
        }
        for (Future<Long> longFuture : resultList) {
            sum3 += longFuture.get();
        }
        System.out.println("耗时：" + (System.currentTimeMillis() - start3) + " 结果："+sum3);
        executorService.shutdown();
    }
    private static class AddRecursiveTask extends RecursiveTask<Long> {
        private int[] arr;
        private int from;
        private int to;
        public AddRecursiveTask(int[] arr, int from, int to) {
            this.arr = arr;
            this.from = from;
            this.to = to;
        }
        @Override
        protected Long compute() {
            long sum = 0;
            if (to - from <= 1000000) {
                for (int i = from; i < to; i++) {
                    sum += arr[i]*3/3*3/3*3/3*3/3*3/3*3/3;
                }
            } else {
                int middle = (from + to) >>> 1;
                AddRecursiveTask leftTask = new AddRecursiveTask(arr, from, middle);
                AddRecursiveTask rightTask = new AddRecursiveTask(arr, middle, to);
                leftTask.fork();
                sum = rightTask.compute() + leftTask.join();
            }
            return sum;
        }
    }
}
