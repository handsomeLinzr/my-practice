package com.example.serial.V3;

/**
 * 序列化接口
 */
public interface ISerializer {

    /**
     * 序列化
     * @param t
     * @param <T>
     * @return
     */
    default <T> byte[] serialize(T t) {
        throw new RuntimeException("序列化失败");
    }

    /**
     * 反序列化
     * @param bytes
     * @param clazz
     * @param <T>
     * @return
     */
    default <T> T deserialize(byte[] bytes, Class<T> clazz) {
        throw new RuntimeException("反序列化失败");
    }

}
