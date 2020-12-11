package com.example.pattern.proxy.staticP;

import org.junit.jupiter.api.Test;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/11 9:42 上午
 * @since V1.0.0
 */
public class StaticProxyTest {

    @Test
    public void test1() {
        // 普通直接调用目标对象
        RealSubject realSubject = new RealSubject();
        System.out.println(realSubject.doSomeThing());
    }

    @Test
    public void test2() {
        // 应用静态代理调用目标对象
        RealSubject realSubject = new RealSubject();
        ProxySubject proxySubject = new ProxySubject(realSubject);
        System.out.println(proxySubject.doSomeThing());
    }

}
