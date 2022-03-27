package com.example.mashibing.jvm;

/**
 * Description:
 *
 * @author Linzherong
 * @date 2022/3/27 1:03 上午
 */
public class JVM_Executor_01 {

    public static void main(String[] args) {
        for (long i = 0; i < 10_0000; i++) {
            m();
        }
        long start = System.currentTimeMillis();
        for (long i = 0; i < 10_0000; i++) {
            m();
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    private static void m() {
        for (long i = 0; i < 10_0000; i++) {
            long j = i%3;
        }
    }

}
