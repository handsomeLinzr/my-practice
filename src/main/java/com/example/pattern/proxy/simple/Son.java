package com.example.pattern.proxy.simple;

/**
 * Description: 目标类
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/11 9:29 上午
 * @since V1.0.0
 */
public class Son implements Person {
    @Override
    public void findLove() {
        System.out.println(" I WANT TO FIND LOVE");
    }
}
