package com.example.pattern.proxy.staticP;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/11 9:39 上午
 * @since V1.0.0
 */
public class ProxySubject implements Subject {

    private final RealSubject realSubject;

    public ProxySubject(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public int doSomeThing() {
        System.out.println("proxy do something begin");
        int i = this.realSubject.doSomeThing();
        System.out.println("proxy do something end");
        return i + 1;
    }
}
