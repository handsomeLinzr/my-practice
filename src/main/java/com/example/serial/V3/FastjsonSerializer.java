package com.example.serial.V3;

import com.alibaba.fastjson.JSON;

public class FastjsonSerializer implements ISerializer{
    @Override
    public <T> byte[] serialize(T t) {
        String string = JSON.toJSONString(t);
        return string.getBytes();
    }

    @Override
    public <T> T deserialize(byte[] bytes, Class<T> clazz) {
        return JSON.parseObject(new String(bytes), clazz);
    }
}
