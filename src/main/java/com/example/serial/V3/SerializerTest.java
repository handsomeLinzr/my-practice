package com.example.serial.V3;

import com.example.serial.V3.po.User;

import java.util.Arrays;

public class SerializerTest {

    public static void main(String[] args) {
//        ISerializer serializer = new JavaSerializer();  // 94  数据大 效率低 无法跨语言
//        ISerializer serializer = new XStreamSerializer();  // 99   可读性高 数据大
//        ISerializer serializer = new FastjsonSerializer();  // 23   可读性高  数据较xml小  传输效率不够高，目前分布式用得多
        ISerializer serializer = new HessianSerializer();  // 58  二进制  跨语言
        User user = new User();
        user.setName("123");
        user.setAge(22);
        byte[] bytes = serializer.serialize(user);
        System.out.println(bytes.length);
        System.out.println(new String(bytes));


        User deserialize = serializer.deserialize(bytes, User.class);
        System.out.println(deserialize);

    }

}
