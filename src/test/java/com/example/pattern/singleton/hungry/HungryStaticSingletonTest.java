package com.example.pattern.singleton.hungry;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author LZR
 * @date 2020/11/28-22:41
 */
public class HungryStaticSingletonTest {

    // 正常调用
    @Test
    public void getInstance1() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 20; i++) {
            executorService.execute(() -> System.out.println(Thread.currentThread().getName() + "---" + HungryStaticSingleton.getInstance()));
        }
    }

    // 反射调用,设置强制构造方法后没法确保唯一
    @Test
    public void getInstance2() {
        Class<HungryStaticSingleton> clazz = HungryStaticSingleton.class;
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        try {
            Constructor<HungryStaticSingleton> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            for (int i = 0; i < 10; i++) {
                executorService.execute(() -> {
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

    // 反射设置单例属性，当属性值不加final时，这种操作会导致可能拿到的属性不是单例
    @Test
    public void getInstance3() {
        // 显示单例的地址
        System.out.println(HungryStaticSingleton.getInstance());
        System.out.println(HungryStaticSingleton.getInstance());
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // 反射强制获取构造方法， 并设置属性
        try {
            Class<HungryStaticSingleton> clazz = HungryStaticSingleton.class;
            Constructor<HungryStaticSingleton> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);

            Field[] files = clazz.getDeclaredFields();
            files[0].setAccessible(true);
            for (int i = 0; i < 10; i++) {
                executorService.execute(() -> {
                    try {
                        files[0].set(HungryStaticSingleton.getInstance(), constructor.newInstance());
                        System.out.println(Thread.currentThread().getName() + "---" + HungryStaticSingleton.getInstance());
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
