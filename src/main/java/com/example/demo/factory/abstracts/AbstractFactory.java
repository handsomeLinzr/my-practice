package com.example.demo.factory.abstracts;

/**
 * @author LZR
 * @date 2020/10/10-21:02
 */
public class AbstractFactory {
    public static void main(String[] args) {
        IFactory factory = new JavaFactory();
        factory.source().source();
        factory.video().video();
    }
}
