package com.example.serial.V3;

/**
 * Description: 自定义序列化接口标准
 *
 * @author Linzr
 * @version V2.0.0
 * @date 2021/6/9 4:15 下午
 * @since V2.0.0
 */
public interface ISerializer {

    /**
     * 序列化成字节数组
     * @param t
     * @param <T>
     * @return
     */
    <T> byte[] serializer(T t);

    <T> T deserializer(byte[] data, Class<T> clazz);

}
