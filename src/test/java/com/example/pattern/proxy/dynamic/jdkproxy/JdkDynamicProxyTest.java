package com.example.pattern.proxy.dynamic.jdkproxy;

import org.junit.jupiter.api.Test;
//import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/11 2:35 下午
 * @since V1.0.0
 */
public class JdkDynamicProxyTest {

    @Test
    public void test1() throws Exception {
        Son son = new Son();
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(son);
        // 获得son的代理对象，用 Person 接受，因为生成的代理对象是实现了和son实现的同个接口Person
        Person proxy = (Person) myInvocationHandler.getProxy();
        proxy.findJob();
        System.out.println(proxy.findLove());
        System.out.println(proxy.getClass());   // 生成的代理对象为 com.sun.proxy.$Proxy9 类

//        Object object = myInvocationHandler.getProxy();
//        Method findJob = object.getClass().getMethod("findJob", null);
//        findJob.invoke(object);

//         将代理类的class文件下到本地
//        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy9", new Class[]{Person.class});
//        FileOutputStream fileOutputStream = new FileOutputStream("/Users/lzr/$Proxy9.class");
//        fileOutputStream.write(bytes);
//        fileOutputStream.flush();
//        fileOutputStream.close();
    }
}
