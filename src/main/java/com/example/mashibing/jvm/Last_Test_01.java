package com.example.mashibing.jvm;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Description:
 *
 * @author Linzherong
 * @date 2022/4/10 7:52 下午
 */
public class Last_Test_01 implements Serializable, Cloneable {

    // 查看classfile用
    private int i1 = 1;
    public int m() {
        return i1;
    }

    public static void main(String[] args) {
        Last_Test_01 instance = new Last_Test_01();
        instance.p1();
    }

    /**
     * ClassLoader
     */
    public void p1() {
        System.out.println(String.class.getClassLoader());
        System.out.println(jdk.dynalink.Namespace.class.getClassLoader());
        System.out.println(jdk.dynalink.Namespace.class.getClassLoader().getClass().getClassLoader());
        System.out.println(Last_Test_01.class.getClassLoader());
        System.out.println(Last_Test_01.class.getClassLoader().getClass().getClassLoader());
        System.out.println(Last_Test_01.class.getClassLoader().getParent());
        System.out.println(Last_Test_01.class.getClassLoader().getParent().getParent());
    }

    /**
     * 自定义classLoader
     */
    static class MyClassLoader extends ClassLoader {
        // 重写 findClass
        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            /*
            1. 获取当前的项目根路径
            2. 将根路径和需要加载的类名组装成class文件的绝对路径
            3. 用 InputStream读取class文件，用ByteArrayOutputStream写出文件流到byte数组
            4. 调用 defineClass 方法加载成Class对象并返回
             */
            return super.findClass(name);
        }
    }

    /**
     * 打破双亲委派，重写loadClass方法即可
     * 由于ClassLoader的 locdClass方法已经是一个模板（模板方法模式），已经定义好了先从parent加载，
     * 所以打破双亲委派机制，就不能再用ClassLoader的loadClass方法，而应该重写该方法
     */
    static class MyClassLoaderWithoutParent extends ClassLoader {
        public MyClassLoaderWithoutParent() {
            // 可以调用 super 方法指定自己的父加载器
            super(new MyClassLoader());
        }
        @Override
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            return super.loadClass(name);
        }
    }

}
