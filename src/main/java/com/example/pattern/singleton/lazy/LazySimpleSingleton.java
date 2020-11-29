package com.example.pattern.singleton.lazy;

/**
 * @author LZR
 * @date 2020/11/29-15:21
 */
public class LazySimpleSingleton {

    private LazySimpleSingleton() {
        /*// 这种方式的话，必须要确保先实例化过一次，否则当没实例化过，LAZY_SIMPLE_SINGLETON 总是为null，就可能直接被反射侵入
        if (LAZY_SIMPLE_SINGLETON != null) {
            throw new RuntimeException("不允许再创建了");
        }*/


        StackTraceElement stackTraceElement = (Thread.currentThread().getStackTrace())[2];
        if (! this.getClass().getName().equals(stackTraceElement.getClassName()) ||
            !"getInstance".equals(stackTraceElement.getMethodName())) {
            throw new RuntimeException("不允许");
        }
    }

    private static LazySimpleSingleton LAZY_SIMPLE_SINGLETON = null;

    // 加 synchronized 同步锁保证单例 优点：简单， 缺点：每次进去这个方法都会进行获取锁和释放锁操作，降低效率
    // jdk1.6后对synchronized进行了优化，但还有更优化的做法
    public static synchronized LazySimpleSingleton getInstance() {
        if (LAZY_SIMPLE_SINGLETON == null) {
            LAZY_SIMPLE_SINGLETON = new LazySimpleSingleton();
        }
        return LAZY_SIMPLE_SINGLETON;
    }

}
