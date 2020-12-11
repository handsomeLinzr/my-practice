package com.example.pattern.proxy.simple;

/**
 * Description: 代理类
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/11 9:29 上午
 * @since V1.0.0
 */
public class Father implements Person{

    private final Son son;

    public Father(Son son) {
        this.son = son;
    }

    @Override
    public void findLove() {
        System.out.println("I HELP YOU...");
        this.son.findLove();
        System.out.println("HELP YOU ENDING...");
    }
}
