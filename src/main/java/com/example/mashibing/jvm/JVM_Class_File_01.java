package com.example.mashibing.jvm;

/**
 * Description: jvm小程序1
 *
 * @author Linzherong
 * @date 2022/3/9 1:01 下午
 */
public class JVM_Class_File_01 {

    private int i = 0;
    private final Object lock = new Object();

    public void m1() {
        synchronized (lock) {
            i++;
        }
    }

    public static void main(String[] args) {
        System.out.println(JVM_Linnking_01.D.B);
    }

}
