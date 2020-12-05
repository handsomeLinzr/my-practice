package com.example.pattern.singleton.threadlocal;

/**
 * Description: ThreadLocal形式单例, 只有在第一次调用的时候才会执行new 操作，所以是懒汉式单例模式
 *  伪单例模式，其实只是同个线程内拿到的对象唯一
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/4 5:57 下午
 * @since V1.0.0
 */
public class ThreadLocalSingleton {

    private ThreadLocalSingleton() {
    }

    private static final ThreadLocal<ThreadLocalSingleton> THREAD_LOCAL = ThreadLocal.withInitial(ThreadLocalSingleton::new);

    public static ThreadLocalSingleton getInstance() {
        return THREAD_LOCAL.get();
    }

}
