package com.example.pattern.singleton.lazy;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author LZR
 * @date 2020/11/29-16:25
 */
public class LazySimpleSingletonTest {

    // 正常访问
    @Test
    public void getInstance1() {
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            service.execute(() -> System.out.println(Thread.currentThread().getName() + "--" + LazySimpleSingleton.getInstance()));
        }
    }

    // 已在构造方法拦截
    @Test
    public void getInstance2() {
        ExecutorService service = Executors.newFixedThreadPool(5);
        try {
            for (int i = 0; i < 10; i++) {
                Class<LazySimpleSingleton> clazz = LazySimpleSingleton.class;
                Constructor<LazySimpleSingleton> constructor = clazz.getDeclaredConstructor();
                constructor.setAccessible(true);
                service.execute(() -> {
                    try {
                        System.out.println(Thread.currentThread().getName() + "---" + constructor.newInstance());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
