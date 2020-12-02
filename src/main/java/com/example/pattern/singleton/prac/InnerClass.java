package com.example.pattern.singleton.prac;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/11/30 10:08 上午
 * @since V1.0.0
 */
public class InnerClass {

    public InnerClass() {
        System.out.println("inner constructor");
    }

    static {
        System.out.println("inner class static code");
    }

    public static void staticMethod() {
        System.out.println("inner class static method");
    }

    public static class InnerInner {

        public InnerInner() {
            System.out.println("innerinner constructor");
        }

        static {
            System.out.println("inner inner static code");
        }

        public static String innerString = "123";
    }

}
