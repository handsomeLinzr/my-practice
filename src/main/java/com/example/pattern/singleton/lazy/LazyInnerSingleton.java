package com.example.pattern.singleton.lazy;

/**
 * Description: 私有内部类单例模式
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/2 3:24 下午
 * @since V1.0.0
 */
public class LazyInnerSingleton {

    private LazyInnerSingleton() {
        if (Inner.LAZY_INNER_SINGLETON != null) {
            throw new RuntimeException("不允许创建");
        }
    }

    public static LazyInnerSingleton getInstance() {
        return Inner.LAZY_INNER_SINGLETON;
    }

    private static class Inner {
        public static final LazyInnerSingleton LAZY_INNER_SINGLETON = new LazyInnerSingleton();
    }
}
