package com.example.serial.V3;

import com.example.serial.V3.po.PersonProto;
import com.example.serial.V3.po.User;
import com.google.protobuf.InvalidProtocolBufferException;

import java.util.Arrays;

public class SerializerTest {

    public static void main(String[] args) throws InvalidProtocolBufferException {
//        ISerializer serializer = new JavaSerializer();  // 94  数据大 效率低 无法跨语言
//        ISerializer serializer = new XStreamSerializer();  // 99   可读性高 数据大
//        ISerializer serializer = new FastjsonSerializer();  // 23   可读性高  数据较xml小  传输效率不够高，目前分布式用得多
//        ISerializer serializer = new HessianSerializer();  // 58  二进制  跨语言
//        User user = new User();
//        user.setName("123");
//        user.setAge(22);
//        byte[] bytes = serializer.serialize(user);
//        System.out.println(bytes.length);
//        System.out.println(new String(bytes));


//        User deserialize = serializer.deserialize(bytes, User.class);
//        System.out.println(deserialize);

        PersonProto.Person person = PersonProto.Person.newBuilder().setAge(22).setName("123").build();
        byte[] bytes = person.toByteArray();
        System.out.println(bytes.length);  // 7
        System.out.println(Arrays.toString(bytes));

        PersonProto.Person parseFrom = PersonProto.Person.parseFrom(bytes);
        System.out.println(parseFrom.toString());

    }

}
