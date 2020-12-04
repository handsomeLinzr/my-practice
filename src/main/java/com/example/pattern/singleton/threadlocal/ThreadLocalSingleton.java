package com.example.pattern.singleton.threadlocal;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/4 5:57 下午
 * @since V1.0.0
 */
public class ThreadLocalSingleton {

    private ThreadLocalSingleton() {}

    private static final ThreadLocal<ThreadLocalSingleton> threadLocal = new ThreadLocal<ThreadLocalSingleton>() {
        @Override
        protected ThreadLocalSingleton initialValue() {
            return new ThreadLocalSingleton();
        }
    };

}
