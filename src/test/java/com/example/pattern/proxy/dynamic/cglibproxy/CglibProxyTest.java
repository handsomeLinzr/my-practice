package com.example.pattern.proxy.dynamic.cglibproxy;

import org.junit.jupiter.api.Test;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/13 10:43 下午
 * @since V1.0.0
 */
public class CglibProxyTest {

    @Test
    public void test() {
        MyMethodInterceptor myMethodInterceptor = new MyMethodInterceptor();
        People proxy = (People) myMethodInterceptor.getProxy(People.class);
        proxy.marryWife();
        proxy.buyHouse();
    }

}
