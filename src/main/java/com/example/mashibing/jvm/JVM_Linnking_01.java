package com.example.mashibing.jvm;

import java.util.Date;

/**
 * Description: class文件链接过程
 *
 * @author Linzherong
 * @date 2022/3/26 11:26 下午
 */
public class JVM_Linnking_01 {


    public static void main(String[] args) {
        JVM_Linnking_01 h = new JVM_Linnking_01();
    }

    // 内部类和主类的加载没有关系，不会因为内部类的加载而跟着加载，反之亦然
    static {
        System.out.println("out class");
    }

    public static class D {
        public static int a;  // 输出a会执行静态代码块
        public static final int B = 0;  // 输出B不会执行静态代码块
        static {
            System.out.println("static inner class");
        }
        private int d;
    }

}

class A {
    static {
        System.out.println("A");
    }
}

class B extends A{
    static {
        System.out.println("B");  // 执行静态代码块必先加载父类，执行父类静态代码块
    }
}


