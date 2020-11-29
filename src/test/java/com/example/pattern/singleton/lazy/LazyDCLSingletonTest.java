package com.example.pattern.singleton.lazy;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author LZR
 * @date 2020/11/29-18:09
 */
public class LazyDCLSingletonTest {

    // 正常访问
    @Test
    public void getInstance() {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            service.execute(() -> System.out.println(Thread.currentThread().getName() + "---" + LazyDCLSingleton.getInstance()));
        }
    }

    // 利用反射还是可以破坏单例
    @Test
    public void getInstance1() throws Exception{
        System.out.println(LazyDCLSingleton.getInstance());

        Class<LazyDCLSingleton> clazz = LazyDCLSingleton.class;
        Constructor<LazyDCLSingleton> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);

        Field[] files = clazz.getDeclaredFields();
        Field file = files[0];
        file.setAccessible(true);
        file.set(LazyDCLSingleton.getInstance(), constructor.newInstance());
        System.out.println(LazyDCLSingleton.getInstance());
    }

}
