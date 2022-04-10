package com.example.mashibing.juc;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Description: 100_0000 个数中找出最大的10个数
 *
 * @author Linzherong
 * @date 2022/4/5 9:09 下午
 */
public class FindMaxTenNum {

    private static final int MAX = 100_0000;
    private static final int[] ARR = new int[MAX];
    private static final int MAX_REGION = 100;
    private static final Random R = new Random(MAX * 10);

    static {
        // 模拟 100万的数据
        for (int i = 0; i < MAX; i++) {
            ARR[i] = R.nextInt();
        }
    }

    public static void main(String[] args) throws Exception {
        // 线程池
        ForkJoinPool pool = ForkJoinPool.commonPool();
        // 线程池提交任务
        ForkJoinTask<int[]> result = pool.submit(new MaxTenRecursiveTask(0, MAX_REGION));
        // 获得结果
        int[] ints = result.get();
        System.out.println(Arrays.toString(ints));
    }

    private static class MaxTenRecursiveTask extends RecursiveTask<int[]> {
        // from to 为需要获得的区间
        private final int from;
        private final int to;
        public MaxTenRecursiveTask(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        protected int[] compute() {
            int r =  to - from;
            // 比较区间在100内，获得其中最大的10个数
            if (r <= MAX_REGION) {
                int[] result = new int[MAX_REGION];
                int j = 0;
                for (int i = from; i < to; i++) {
                    result[j++] = ARR[i];
                }
                // 排列
                Arrays.sort(result);
                // 获得最后的10个数（最大）
                return Arrays.copyOfRange(result, r-10, r);
            } else {
                // 将本任务拆分为两个子任务
                int middle = (to - from) >>>1 + from;
                MaxTenRecursiveTask task1 = new MaxTenRecursiveTask(from, middle);
                MaxTenRecursiveTask task2 = new MaxTenRecursiveTask(middle, to);
                task1.fork();
                task2.fork();
                // 获得两个子任务中每个任务的最大10个数
                int[] result1 = task1.join();
                int[] result2 = task2.join();
                // 将两个result合并并排列，获取最后10个数（最大）
                int[] result = Arrays.copyOf(result1, result1.length + result2.length);
                System.arraycopy(result2, 0, result, result1.length, result2.length);
                return Arrays.copyOfRange(result, result1.length + result2.length-10, result1.length + result2.length);
            }
        }
    }
}
