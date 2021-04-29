package com.example.thread;

public class HappenBeforeDemo {

    public static void main(String[] args) {
        new Thread(() -> System.out.println("a")).start();
    }

}
