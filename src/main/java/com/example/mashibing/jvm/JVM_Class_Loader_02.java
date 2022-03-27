package com.example.mashibing.jvm;

/**
 * Description:
 *
 * @author Linzherong
 * @date 2022/3/26 10:40 下午
 */
public class JVM_Class_Loader_02 {
    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.boot.class.path"));  // BootstrapClassLoader 加载位置
        System.out.println(System.getProperty("java.ext.dirs"));  // ExtClassLoader 加载位置
        System.out.println(System.getProperty("java.class.path"));  // AppClassLoader 加载位置
    }
}
