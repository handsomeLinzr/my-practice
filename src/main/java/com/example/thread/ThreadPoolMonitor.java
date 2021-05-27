package com.example.thread;

import java.util.Date;
import java.util.concurrent.*;

/**
 * 对线程池监控
 */
public class ThreadPoolMonitor extends ThreadPoolExecutor {

    private final ConcurrentHashMap<String, Date> startTimes;  // 存放线程执行时间

    public ThreadPoolMonitor(int corePoolSize,   // 核心线程数
                             int maximumPoolSize,  // 最大线程数
                             long keepAliveTime,  // 线程空闲存活时间
                             TimeUnit unit,   // 时间单位
                             BlockingQueue<Runnable> workQueue) {  // 任务存放的阻塞队列
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        startTimes = new ConcurrentHashMap<>();
    }

    /**
     * 自定义可缓存线程池创建方法
     * @return
     */
    public static ExecutorService newCachedThreadPool() {
        return new ThreadPoolMonitor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
    }

    /*U
    编写各个监控的后门方法
     */
    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        this.startTimes.put(String.valueOf(r.hashCode()), new Date());  // 存放当前时间
        super.beforeExecute(t, r);
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        long time = System.currentTimeMillis() - this.startTimes.remove(String.valueOf(r.hashCode())).getTime();  // 执行时间
        int poolSize = this.getPoolSize();
        int corePoolSize = this.getCorePoolSize();
        int activeCount = this.getActiveCount();
        long completedTaskCount = this.getCompletedTaskCount();
        long taskCount = this.getTaskCount();
        int maximumPoolSize = this.getMaximumPoolSize();
        long keepAliveTime = this.getKeepAliveTime(TimeUnit.SECONDS);
        System.out.print("任务耗时: "+time +"\n");
        System.out.print("初始线程数:"+poolSize+"\n");
        System.out.print("核心线程数:"+corePoolSize+"\n");
        System.out.print("正在执行的任务数量:"+activeCount+"\n");
        System.out.print("已经执行的任务数:"+completedTaskCount+"\n");
        System.out.print("任务总数:"+taskCount+"\n");
        System.out.print("最大允许的线程数:"+maximumPoolSize+"\n");
        System.out.print("线程空闲时间:"+keepAliveTime+"\n");
        System.out.println();
        super.afterExecute(r, t);
    }

    @Override
    public void shutdown() {
        System.out.println("已经执行的任务数：" + this.getCompletedTaskCount());
        System.out.println("当前存活的线程数：" + this.getActiveCount());
        System.out.println("当前队列的任务数：" + this.getQueue().size());
        super.shutdown();
    }


}
