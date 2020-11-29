package com.example.pattern.singleton.hungry;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/11/27 5:17 下午
 * @since V1.0.0
 */
public class HungrySimpleSingletonTest {

    // 正常访问
    @Test
    public void getInstance1() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> System.out.println(Thread.currentThread().getName() + "---" + HungrySimpleSingleton.getInstance()));
        }
    }

    // 通过反射强制获得构造方法访问, 只能通过在构造方法内进行判断调用方法进行避免
    @Test
    public void getInstance2() {
        try {
            Class<HungrySimpleSingleton> clazz = HungrySimpleSingleton.class;
            Constructor<HungrySimpleSingleton> declaredConstructor = clazz.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);
            ExecutorService executorService = Executors.newFixedThreadPool(3);
            for (int i = 0; i < 10; i++) {
                executorService.execute(() -> {
                    try {
                        System.out.println(Thread.currentThread().getName() + "---" + declaredConstructor.newInstance());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 反射拿到属性
    @Test
    public void getInstance3() {
        Class<HungrySimpleSingleton> clazz = HungrySimpleSingleton.class;
        try {
            Field field = clazz.getDeclaredField("HUNGRY_SIMPLE_SINGLETON");
            field.setAccessible(true);
            System.out.println(field.get(clazz));

            // 加 final 的原因: 确保单例属性不会被反射等情况替换掉
            Constructor<HungrySimpleSingleton> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            HungrySimpleSingleton hungrySimpleSingleton = constructor.newInstance();
            field.set("HUNGRY_SIMPLE_SINGLETON", hungrySimpleSingleton);
            System.out.println(field.get(clazz));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
