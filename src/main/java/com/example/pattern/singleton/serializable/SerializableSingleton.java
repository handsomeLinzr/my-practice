package com.example.pattern.singleton.serializable;

import java.io.Serializable;

/**
 * Description: 可序列化单例模式
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/3 11:05 上午
 * @since V1.0.0
 */
public class SerializableSingleton implements Serializable {

    private SerializableSingleton() {}

    private static final SerializableSingleton SERIALIZABLE_SINGLETON = new SerializableSingleton();

    public static SerializableSingleton getInstance() {
        return SERIALIZABLE_SINGLETON;
    }

    /*
     使得避免序列化的时候最终返回对象的时候会调用这个方法，保证单例
     实际上在jvm层面上会实例化出一个实例，但是最后返回的还是自己本身的这个方法的单例，实例出来的单例不会有任何引用，最终会被gc释放掉
     每次序列化都会实例出一个没被调用的实例，因此当有大幅度的序列化的时候，还是会造成空间内存浪费的可能
     */
    private Object readResolve() {
        return SERIALIZABLE_SINGLETON;
    }

}
