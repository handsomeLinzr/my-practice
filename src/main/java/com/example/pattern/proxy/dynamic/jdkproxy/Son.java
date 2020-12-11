package com.example.pattern.proxy.dynamic.jdkproxy;

/**
 * Description: 目标类
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/11 2:23 下午
 * @since V1.0.0
 */
public class Son implements Person {
    @Override
    public void findJob() {
        System.out.println("son find job");
    }

    @Override
    public int findLove() {
        System.out.println("son find love");
        return 10;
    }
}
