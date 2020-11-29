package com.example.pattern.singleton.hungry;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author LZR
 * @date 2020/11/29-17:02
 */
public class HungryConstructorSingletonTest {

    // 正常访问
    @Test
    public void getInstance1() {
        System.out.println(HungryConstructorSingleton.getInstance());
        System.out.println(HungryConstructorSingleton.getInstance());
        System.out.println(HungryConstructorSingleton.getInstance());
    }

    // 通过反射拿到构造方法强制访问，已拦截
    @Test
    public void getInstance2() {
        ExecutorService service = Executors.newCachedThreadPool();
        Class<HungryConstructorSingleton> clazz = HungryConstructorSingleton.class;
        try {
            Constructor<HungryConstructorSingleton> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            for (int i = 0; i < 10; i++) {
                service.execute(() -> {
                    try {
                        System.out.println(Thread.currentThread().getName() + "--" + constructor.newInstance());
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
