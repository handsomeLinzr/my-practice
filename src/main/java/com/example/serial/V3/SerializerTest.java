package com.example.serial.V3;

import com.example.serial.V3.po.User;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Linzr
 * @version V2.0.0
 * @date 2021/6/9 4:31 下午
 * @since V2.0.0
 */
public class SerializerTest {

    public static void main(String[] args) {
//        ISerializer serializer = new JavaSerializer();   // java 序列化 94
        ISerializer serializer = new XStreamSerializer();   // xml 序列化 94
        User user = new User();
        user.setName("123");
        user.setAge(22);
        byte[] bytes = serializer.serializer(user);
        System.out.println(bytes.length);
        System.out.println(new String(bytes));

        User deserializer = serializer.deserializer(bytes, User.class);
        System.out.println(deserializer);

    }
}
