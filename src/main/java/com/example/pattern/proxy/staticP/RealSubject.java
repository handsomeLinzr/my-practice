package com.example.pattern.proxy.staticP;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/11 9:36 上午
 * @since V1.0.0
 */
public class RealSubject implements Subject {
    @Override
    public int doSomeThing() {
        System.out.println("do something real");
        return 1;
    }
}
