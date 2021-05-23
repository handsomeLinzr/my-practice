package com.example.pattern;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    public static void main(String[] args) {
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>(2);
//        2Thread thread1 = new Thread(() -> {
//            map.put(1, "1");
//        });
//        Thread thread2 =new Thread(() -> {
//            map.put(2, "2");
//        });
//        Thread thread3 =new Thread(() -> {
//            map.put(3, "3");
//        });
//        Thread thread4 =new Thread(() -> {
//            map.put(4, "4");
//        });
//        Thread thread5 =new Thread(() -> {
//            map.put(5, "5");
//        });
//        Thread thread6 =new Thread(() -> {
//            map.put(6, "6");
//        });
//        Thread thread7 = new Thread(() -> {
//            map.put(7, "7");
//        });
//
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread4.start();
//        thread5.start();
//        thread6.start();
//        thread7.start();
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");
        map.put(8, "8");

    }


}
