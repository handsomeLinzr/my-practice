package com.example.serial.V3;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Description: JAVA  序列化
 *
 * @author Linzr
 * @version V2.0.0
 * @date 2021/6/9 4:21 下午
 * @since V2.0.0
 */
public class JavaSerializer implements ISerializer{
    @Override
    public <T> byte[] serializer(T t) {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)){
            objectOutputStream.writeObject(t);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("序列化失败 " + e);
        }
    }

    @Override
    public <T> T deserializer(byte[] data, Class<T> clazz) {
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
             ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)){
            return (T) objectInputStream.readObject();
        } catch (Exception e) {
            throw new RuntimeException("反序列化失败 " + e);
        }
    }
}
