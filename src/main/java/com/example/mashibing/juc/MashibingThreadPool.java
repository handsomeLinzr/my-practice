package com.example.mashibing.juc;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Description: 线程池练习
 *
 * @author Linzherong
 * @date 2022/3/1 2:36 下午
 */
public class MashibingThreadPool {

    private static final int NUM = 10000000;
    private static final int[] ARR;
    private static final int MAX_COUNT = 5000;
    static {
        ARR = new int[NUM];
        Random random = new Random();
        for (int i = 0; i < NUM; i++) {
            ARR[i] = random.nextInt(100);
        }
    }

    public static void main(String[] args) {
        try {
            forkJoinPoolP();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Callable练习
     * 线程池执行
     */
    private static void callableP() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(()->{
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello callable";
        });
        System.out.println(Thread.currentThread().getName() + "继续执行");
        System.out.println(future.get());
        System.out.println(Thread.currentThread().getName() + "阻塞后继续执行");
        executorService.shutdown();
    }

    /**
     * FutureTask（Runnable+Callable）练习
     * 可以做runnable，也可以做task
     */
    private static void FutureTaskP() throws Exception {
        ExecutorService service = Executors.newSingleThreadExecutor();
        FutureTask<String> futureTask = new FutureTask(()-> "hello futureTask");
        service.submit(futureTask);
        System.out.println(futureTask.get());  // 阻塞
        service.shutdown();
    }

    /**
     * workStealingPool 练习
     */
    private static void workStealingPoolP() throws Exception {
        long start = System.currentTimeMillis();
        ExecutorService service = Executors.newWorkStealingPool();
        Future<Double> f1 =service.submit(MashibingThreadPool::getPriceJD);
        Future<Double> f2 =service.submit(MashibingThreadPool::getPriceTB);
        Future<Double> f3 = service.submit(MashibingThreadPool::getPriceTM);
        System.out.println(((f1.get()+f2.get()+f3.get())/3));
        System.out.println("======>" + (System.currentTimeMillis() - start));
        service.shutdown();
    }

    /**
     * completableFuture 并行线程任务练习
     */
    private static void completableFuture() throws Exception {
        // 3个任务串行
        long start = System.currentTimeMillis();
        Double price1 = getPriceTM();
        Double price2 =getPriceTB();
        Double price3 =getPriceJD();
        System.out.println((price1+price2+price3)/3);
        System.out.println("串行耗时：" + (System.currentTimeMillis() - start));

        // 3个任务并行
        ExecutorService service = Executors.newCachedThreadPool();
        long startp = System.currentTimeMillis();
        Future<Double> f1 = service.submit(() -> getPriceTM());
        Future<Double> f2 = service.submit(() -> getPriceTB());
        Future<Double> f3 = service.submit(() -> getPriceJD());
        System.out.println((f1.get()+f2.get()+f3.get())/3);
        System.out.println("并行耗时：" + (System.currentTimeMillis() - startp));
        service.shutdown();

        // 3个任务管理并行
        long startc = System.currentTimeMillis();
        CompletableFuture<Double> cf1 = CompletableFuture.supplyAsync(MashibingThreadPool::getPriceTM);
        CompletableFuture<Double> cf2 = CompletableFuture.supplyAsync(MashibingThreadPool::getPriceTB);
        CompletableFuture<Double> cf3 = CompletableFuture.supplyAsync(MashibingThreadPool::getPriceJD);
        CompletableFuture.allOf(cf1, cf2, cf3)
                .whenComplete((u,t)->{
                    try {
                        System.out.println((cf1.get() + cf2.get() + cf3.get()) / 3);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }).join();
        System.out.println("CompletableFuture并行耗时：" + (System.currentTimeMillis() - startc));
    }

    /**
     * Forkjoin练习
     */
    private static void forkJoinPoolP() throws Exception {
        // 单线程方式  29
        long start = System.currentTimeMillis();
        long result = 0;
        for (int i = 0; i < NUM; i++) {
            result += (ARR[i]*ARR[27]*ARR[35]*ARR[0]/ARR[25]);
        }
        System.out.printf("%s======>消耗时间==>[%s],结果：[%s]\n",Thread.currentThread().getName(),(System.currentTimeMillis() - start),result);

        // forkjoin方式 2
        ForkJoinPool pool = new ForkJoinPool();
        long forkStart = System.currentTimeMillis();
        ForkJoinTask<Long> submit = pool.submit(new AddTask(0, NUM));
        System.out.printf("消耗时间[%s],结果：[%s]\n",(System.currentTimeMillis() - forkStart),submit.get());
    }

    /**
     * forkjoin 执行练习
     * @throws Exception
     */
    private static void forkRunnable() throws Exception {
        ForkJoinPool pool = new ForkJoinPool();
        pool.execute(new AddRunnable(0, NUM));
        pool.shutdown();
    }
    static class AddRunnable extends RecursiveAction {
        // 开始和结束位置
        private final int begin,end;
        public AddRunnable(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }
        @Override
        protected void compute() {
            if (end - begin <= MAX_COUNT) {
                long result = 0;
                for (int i = begin; i < end; i++) result += (ARR[i]*ARR[27]*ARR[35]*ARR[0]/ARR[25]);
                System.out.printf("%s===>from [%s] to [%s] ==>result [%s]\n",
                        Thread.currentThread().getName(),begin,end,result);
            } else {
                int middle = begin + ((end-begin)>>1);
                ForkJoinTask<Void> fork1 = new AddRunnable(begin, middle).fork();
                ForkJoinTask<Void> fork2 = new AddRunnable(middle, end).fork();
                fork1.join();
                fork2.join();
            }
        }
    }
    /**
     * forkjoin 任务练习
     */
    static class AddTask extends RecursiveTask<Long> {
        private final int begin,end;

        public AddTask(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }
        @Override
        protected Long compute() {
            if (end - begin <= MAX_COUNT) {
                // 在最大范围内计算
                long result = 0;
                for (int i = begin; i < end; i++) result += (ARR[i]*ARR[27]*ARR[35]*ARR[0]/ARR[25]);
                return result;
            }
            // 超过最大范围数则分解任务
            int middle = begin + ((end-begin)>>1);
            ForkJoinTask<Long> fork1 = new AddTask(begin, middle).fork();
            ForkJoinTask<Long> fork2 = new AddTask(middle, end).fork();
            return fork1.join() + fork2.join();
        }
    }


    /**
     * 模拟获取价格
     * @return
     */
    private static Double getPriceTM() {
        try {
            System.out.println(Thread.currentThread().getName() + "=开始=======>");
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "=结束=======>");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0.4;
    }
    private static Double getPriceJD() {
        try {
            System.out.println(Thread.currentThread().getName() + "=开始=======>");
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "=结束=======>");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0.2;
    }
    private static Double getPriceTB() {
        try {
            System.out.println(Thread.currentThread().getName() + "=开始=======>");
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "=结束=======>");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0.5;
    }



}
