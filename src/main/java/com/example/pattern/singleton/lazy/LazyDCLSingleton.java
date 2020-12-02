package com.example.pattern.singleton.lazy;

/**
 * double check lock 双重校验锁
 * @author LZR
 * @date 2020/11/29-17:57
 */
public class LazyDCLSingleton {

    private LazyDCLSingleton() {}

    // 避免指令重排序,避免出现 当对象先建立连接但是还没有初始化的时候，另一个线程访问到这个实例不为空直接返回，此时其实该实例只有指向内存地址但还没初始化
    private volatile static LazyDCLSingleton lazyDCLSingleton = null;

    public static LazyDCLSingleton getInstance() {
        // 判断是否已经被实例化
        if (lazyDCLSingleton == null) {
            synchronized (LazyDCLSingleton.class) {
                // 再一次检查，毕竟有其他线程先一步实例化了实例
                if (lazyDCLSingleton == null) {
                    lazyDCLSingleton = new LazyDCLSingleton();
                }
            }
        }
        return lazyDCLSingleton;
    }
}
