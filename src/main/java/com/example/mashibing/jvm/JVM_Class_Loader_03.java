package com.example.mashibing.jvm;

//import com.example.mashibing.juc.JucTest1;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * Description: 自定义classLoader
 *
 * @author Linzherong
 * @date 2022/3/26 10:47 下午
 */
public class JVM_Class_Loader_03 {
    public static void main(String[] args) throws Exception{
        MyClassLoader myClassLoader = new MyClassLoader();
        Class<?> clazz = myClassLoader.loadClass("com.example.mashibing.juc.JucTest1");
        Object h = clazz.newInstance();
        System.out.println(h);
        System.out.println(clazz);
        System.out.println(clazz.getClassLoader());
        System.out.println(myClassLoader.getParent());
    }
}

class MyClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            File file = new File(this.getClass().getResource("/").getPath(), (name.replaceAll(".", File.separator)) + ".class");
            FileInputStream fi = new FileInputStream(file);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int b;
            while ((b = fi.read())!= 0) {
                baos.write(b);
            }
            byte[] buf = baos.toByteArray();
            baos.close();
            fi.close();
            return defineClass(name, buf, 0, baos.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }
}
