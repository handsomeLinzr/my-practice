package com.example.pattern.singleton.lazy;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/2 3:43 下午
 * @since V1.0.0
 */
public class LazyInnerSingletonTest {

    @Test
    public void testGet() {
        System.out.println(LazyInnerSingleton.getInstance());
        System.out.println(LazyInnerSingleton.getInstance());
        System.out.println(LazyInnerSingleton.getInstance());
        System.out.println(LazyInnerSingleton.getInstance());
        System.out.println(LazyInnerSingleton.getInstance());
        System.out.println(LazyInnerSingleton.getInstance());
    }
}
