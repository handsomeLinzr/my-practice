package com.example.serial.V3;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XStreamSerializer implements ISerializer{

    XStream xStream = new XStream(new DomDriver());  // 驱动

    @Override
    public <T> byte[] serialize(T t) {
        return xStream.toXML(t).getBytes();
    }

    @Override
    public <T> T deserialize(byte[] bytes, Class<T> clazz) {
        return (T) xStream.fromXML(new String(bytes));
    }
}
