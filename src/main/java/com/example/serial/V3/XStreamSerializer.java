package com.example.serial.V3;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * Description:
 *
 * @author Linzr
 * @version V2.0.0
 * @date 2021/6/9 4:50 下午
 * @since V2.0.0
 */
public class XStreamSerializer implements ISerializer{

    XStream xStream = new XStream(new DomDriver());  // 加载驱动

    @Override
    public <T> byte[] serializer(T t) {
        return xStream.toXML(t).getBytes();  // 序列化为xml
    }

    @Override
    public <T> T deserializer(byte[] data, Class<T> clazz) {
        return (T) xStream.fromXML(new String(data));
    }
}
