package com.example.pattern.singleton.register;

import com.example.pattern.singleton.utils.ConcurrentExecutor;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/4 2:55 下午
 * @since V1.0.0
 */
public class EnumSingletonTest {

    @Test
    public void testGetInstance() throws Exception {

        String fileName = "EnumSerializable.obj";
        EnumSingleton.getInstance().setObject(new Object());
        System.out.println(EnumSingleton.getInstance().getObject());

        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(EnumSingleton.getInstance());
        outputStream.flush();
        outputStream.close();

        FileInputStream fileInputStream = new FileInputStream(fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        EnumSingleton singleton = (EnumSingleton) objectInputStream.readObject();
        System.out.println(singleton.getObject());
        System.out.println(EnumSingleton.getInstance() == singleton);
        System.out.println(EnumSingleton.getInstance().getObject() == singleton.getObject());
    }

    @Test
    public void testConcurrent() throws Exception {
        Object object = new Object();
        System.out.println(object);
        EnumSingleton.getInstance().setObject(object);

        ConcurrentExecutor.executor(() -> System.out.println(Thread.currentThread().getName() + ":" + EnumSingleton.getInstance().getObject()), 10, 4);
    }

    @Test
    public void testConstructor() throws Exception {
        Class<EnumSingleton> clazz = EnumSingleton.class;
        Constructor<EnumSingleton> constructor = clazz.getDeclaredConstructor(String.class, int.class);
        constructor.setAccessible(true);
        EnumSingleton enumSingleton = constructor.newInstance("123", 123);
    }


}
