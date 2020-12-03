package com.example.pattern.singleton.serializable;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/3 11:12 上午
 * @since V1.0.0
 */
public class SerializableSingletonTest {

    @Test
    public void testGet() throws Exception {
        SerializableSingleton instance1 = SerializableSingleton.getInstance();

        FileOutputStream out = new FileOutputStream("Serializable.obj");
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(instance1);
        oos.flush();
        oos.close();
        out.close();

        FileInputStream in = new FileInputStream("Serializable.obj");
        ObjectInputStream ooi = new ObjectInputStream(in);
        SerializableSingleton instance2 = (SerializableSingleton) ooi.readObject();
        System.out.println(instance1);
        System.out.println(instance2);
        System.out.println(instance1 == instance2);
    }
}
